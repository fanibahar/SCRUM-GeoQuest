function loadXMLDoc(v)
{
    var xmlhttp;

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5 
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("WaypointsCanvas").innerHTML=xmlhttp.responseText;
        }
    }
    
    //for client server use:
    //xmlhttp.open("GET", "http://131.220.239.232:8080/GeoCaching/CreateTourServlet?"+v,true);
    
    xmlhttp.open("GET", "http://localhost:8080/GeoCaching/CreateTourServlet?"+v,true);
    xmlhttp.send();
}

var map;
var markers = [];
var poly;
var polyOptions;
var v="";

function initialize()
{
    var haightAshbury = new google.maps.LatLng(37.7699298, -122.4469157);
    var mapOptions = {zoom: 12, center: haightAshbury, mapTypeId: google.maps.MapTypeId.TERRAIN};
    polyOptions = {strokeColor: '#000000', strokeOpacity: 1.0, strokeWeight: 3};

    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    poly = new google.maps.Polyline(polyOptions);
    poly.setMap(map);

    google.maps.event.addListener(map, 'click', addLatLng);
}

function addLatLng(event)
{

    var path = poly.getPath();

    // Because path is an MVCArray, we can simply append a new coordinate
    // and it will automatically appear
    path.push(event.latLng);
    addMarker(event.latLng);
}

// Add a marker to the map and push to the array.
function addMarker(location)
{
    var marker = new google.maps.Marker({position: location,map: map});
    
    var contentString = "<input type=\"text\" id=\"wayname2\" required placeholder=\"Enter Waypoint Name Here\" />";
                                            
    var infowindow = new google.maps.InfoWindow({
            content: contentString
        });
    
    google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
        });
   
    markers.push(marker);
    v = location.toString();
    
    var name = document.getElementById("wayname").value;
    
    loadXMLDoc("addwaypoint="+v+"&name="+name);
}

// Sets the map on all markers in the array.
function setAllMap(map)
{
    for (var i = 0; i < markers.length; i++)
    {
        markers[i].setMap(map);
    }
    poly.setMap(map);
}

// Removes the overlays from the map, but keeps them in the array.
function clearOverlays()
{
    setAllMap(null);
}

// Shows any overlays currently in the array.
function showOverlays()
{
    setAllMap(map);
}

// Deletes all markers in the array by removing references to them.
function deleteOverlays()
{
    clearOverlays();
    markers = [];
    poly = new google.maps.Polyline(polyOptions);
    poly.setMap(map);
}

function saveTour()
{

    var level;

    if (document.getElementById("low").checked)
    {
        level = "low";
    }

    if (document.getElementById("medium").checked)
    {
        level = "medium";
    }

    if (document.getElementById("high").checked)
    {
        level = "high";
    }
    
    var name = document.getElementById("tourname").value;
    var description = document.getElementById("tourdescription").value;
    
    
    if (name == "" && description == "")
        alert('Please add name and decription!');
    else
    {    
        loadXMLDoc("addtour"+"&level="+level+"&name="+name+"&description="+description);
        deleteOverlays();
    }
}

google.maps.event.addDomListener(window, 'load', initialize);
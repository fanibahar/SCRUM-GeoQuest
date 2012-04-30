<%-- 
    Document   : index
    Created on : Apr 23, 2012, 11:30:43 AM
    Author     : ilyakostrikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Google Maps JavaScript API v3 Example: Overlay Removal</title>
            <style type="text/css">
                #map-canvas {width: 600px; height: 500px}
            </style>
            <script type="text/javascript"
                src="http://maps.googleapis.com/maps/api/js?key=AIzaSyD3lQBr4cZ2do3Nr3QB4iFpQkdjCrS703E&sensor=true">
            </script>
            <script type="text/javascript">
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
                        document.getElementById("ReloadThis").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET", "http://localhost:8080/GoogleMapsAPITest/MapsServlet?"+v,true);
                xmlhttp.send();
            }
            </script>
            <script type="text/javascript">
                var map;
                var markers = [];
                var poly;
                var polyOptions;
                var v="Roseindia";

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
                    marker = new google.maps.Marker({position: location,map: map});
                    markers.push(marker);
                    v = location.toString();
                    loadXMLDoc("addwaypoint="+v);
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
                    loadXMLDoc("addtour");
                    deleteOverlays();
                }

                google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <div>
            <input onclick="clearOverlays();" type=button value="Clear Overlays"/>
            <input onclick="showOverlays();" type=button value="Show All Overlays"/>
            <input onclick="deleteOverlays();" type=button value="Delete Overlays"/>
        </div>
        <div id="map-canvas"></div>
        
        <div>
            <input onclick="saveTour();" type=button value="Save the tour"/>
        </div>
        
        <div id="ReloadThis">

        </div>
    </body>
</html>
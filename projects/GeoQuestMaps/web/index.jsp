<!DOCTYPE html>

<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0; padding: 0 }
  #map_canvas { height: 100% }
</style>

<html>
  <head>
      
    <script type="text/javascript"
    src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDsg0DXvhP6dJtqoin9zc5n6Ng4q9ag1XM&sensor=true"></script>
      
    <script type="text/javascript">
  var geocoder;
  var mainMap;
  var rMap;
  var marker;
  function initialize() {
    geocoder = new google.maps.Geocoder();
        //Main Map
        var mainMapOptions = {
          zoom: 10,
          center: new google.maps.LatLng(50.741887,7.100258),
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        mainMap = new google.maps.Map(document.getElementById('mainMap'),
            mainMapOptions); 
                
        //Click listener
        google.maps.event.addListener(mainMap, 'click', function(update) {
       
        document.getElementById('latLng').value = update.latLng;
        placeMarker(update.latLng, mainMap);

        });
        

  }
  
    function codeAddress() {
        var address = document.getElementById("address").value;
        geocoder.geocode( { 'address': address}, function(update, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            mainMap.setCenter(update[0].geometry.location);
            placeMarker(update[0].geometry.location, mainMap);
            document.getElementById('latLng').value = update[0].geometry.location;

        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
        });
    }
  
       function addWaypoint() {
       // Here we create the array storing every way point and displaying it in the screen
       }
      
      function placeMarker(position, map) {
          marker = new google.maps.Marker({
          position: position,
          map: map,
          draggable: true
        });
        map.panTo(position);
        
        //Dragged Marker
        google.maps.event.addListener(marker, 'dragend', function(update) {
        document.getElementById('latLng').value = update.latLng;
       });
        
      }

</script>
<body onload="initialize()">
    <div>
    <input id="address" type="textbox" value="Bonn, Germany" size="50" maxlength="50">
    <input type="button" value="Search" onclick="codeAddress()">
    </div>
    <div id="mainMap" style="position:absolute;top:30px;left:10px;width:550px; height: 550px"></div>
     <label for="Coordinates" style="position:absolute;top:600px;left:10px;">Coordinates: </label>
    <input id="latLng" type="text" value="" size="40" style="position:absolute;top:600px;left:100px;">
    <input type="button" value="Add WayPoint" onclick="addWaypoint()" style="position:absolute;top:600px;left:450px;">

</body>
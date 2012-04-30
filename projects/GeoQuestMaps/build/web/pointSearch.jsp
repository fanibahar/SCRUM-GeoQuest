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
        
        //Route Map
        var rMapOptions = {
          zoom: 8,
          center: new google.maps.LatLng(50.741887,7.100258),
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        rMap = new google.maps.Map(document.getElementById('rMap'),
            rMapOptions);
            
        //Click listener
        google.maps.event.addListener(mainMap, 'click', function(e) {
        placeMarker(e.latLng, mainMap);
        results == e.latLng;
        });
        
        //Dragged Marker
        google.maps.event.addListener(marker, 'dragend', function(e) {
        updateElevation();
      });
  }
  

    function codeAddress() {
        var address = document.getElementById("address").value;
        geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            mainMap.setCenter(results[0].geometry.location);
            placeMarker(results[0].geometry.location, mainMap);

        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
        });
    }
  
      function placeMarker(position, map) {
        var marker = new google.maps.Marker({
          position: position,
          map: map,
          draggable: true
        });
        map.panTo(position);
      }

</script>
<body onload="initialize()">
    <div>
    <input id="address" type="textbox" value="Bonn, Germany" size="50" maxlength="50">
    <input type="button" value="Search" onclick="codeAddress()">
    </div>
    <div id="mainMap" style="position:absolute;top:30px;left:10px;width:550px; height: 550px"></div>
     <div id="rMap" style="position:absolute;top:30px;left:600px;width:400px; height: 400px"></div>

</body>
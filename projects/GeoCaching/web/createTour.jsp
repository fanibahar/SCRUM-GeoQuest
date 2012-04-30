<%-- 
    Document   : createTour
    Created on : Apr 22, 2012, 11:03:15 AM
    Author     : Ankit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>GeoCaching</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="CSS/Style.css" type="text/css" media="all">
                    <style type="text/css">
                #map-canvas {width: 300px; height: 300px}
            </style>
            <script type="text/javascript"
                src="http://maps.googleapis.com/maps/api/js?key=AIzaSyD3lQBr4cZ2do3Nr3QB4iFpQkdjCrS703E&sensor=true">
            </script>

            
            

            <script type="text/javascript" src = "GoogleMaps.js">
            
            </script>
    </head>

    <body>
        <!-- header -->
        <header>
            <div class="container">
                <h1><a href="index.jsp">GeoCaching</a></h1>
                <nav>
                    <ul>
                        <li><a href="index.jsp" class="current">Home</a></li>
                        <li><a href="createTour.jsp">Create Tour</a></li>
                        <li><a href="editTour.jsp">Edit Tour</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </header>
 
                              
        <div class="main-box">
            <div class="container">
                <div class="inside">
                  
     
                        <div class="form-content">
 
                            <form class="create-tour" method="post" action="#">
 
                                           
                                <fieldset>
                                    <div class="left">
                                        <div class="name">
                                            <label for="name">Name:</label>
                                            <input type="text" id="tourname" required placeholder="Enter Tour Name Here" />
                                        </div>

                                        <div class="description">
                                            <label for="description">Description:</label>
                                            <textarea type="description" rows="3" id="tourdescription" required placeholder="Enter Description Here" ></textarea>
                                        </div>

                                        <div class="radiobtn">
                                            <label for="radiobtn">Difficulty:</label>
                                            <input type="radio"	name="g1" id="low" value="Low"> Low<br>
                                            <input type="radio" name="g1" id="medium" value="Medium" checked> Medium<br>
                                            <input type="radio" name="g1" id="high" value="High">High
                                        </div>
                                                           
                                        
                                        <div class="waypointlocation">
                                            <label for="waypointlocation"><strong>Waypoint Location</strong></label>
                                            <div class="name">
                                                <label for="name">Name:</label>
                                                <input type="text" id="wayname" required placeholder="Enter Waypoint Name Here" />
                                            </div>
                                            <p>
                                                <label for="name">Place:</label>
                                                <input type="text" id="place" required placeholder="Enter Waypoint Name Here" />
                                                <input type="submit" name="Search" id="searchbtn" value="Search">
                                            </p>
                                            
                                            <div id="map-canvas"></div>
                                            <div class="check">
                                                <input type="checkbox" value="Final" />&nbsp Final
                                            </div>
                                            <div class="submit-button">
                                                <input type="submit" value="Add Waypoint" />
                                            </div>	
                                        </div>
                                    </div>
                                    <div class="touroverview">
                                        <label for="touroverview"><strong>Tour Overview</strong></label><br/>
                                           
                                            <div class="submit-button" style="float:left">  
                                                    <input onclick="saveTour();" type=button value="Save the tour"/>
                                            </div>
                                        
                                         <br/>
                                        
                                         <div id="WaypointsCanvas">

                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>	
        <!-- footer -->
        <footer>
            <div class="container">
                <div class="wrapper">
                    <div class="fleft">Copyright - SCRUM 2012</div>
                </div>
            </div>
        </footer>
    </body>
</html>
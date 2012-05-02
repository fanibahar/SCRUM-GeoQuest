<%-- 
    Document   : ListTours
    Created on : May 2, 2012, 10:41:39 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>GeoCaching</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="CSS/Style.css" type="text/css" media="all">
        <script type="text/javascript" src = "ListTours.js">     
        </script> 
        <style type="text/css">
        table.servicesT{          
            color: #404040;
            background-color: #fafafa;
            border: 1px #6699CC solid;
            border-collapse: collapse;
            border-spacing: 0px;
            margin-top: 0px;
            width:100%;
        }
        table.servicesT td.servHd{	
            border-bottom: 2px solid #6699CC;
            background-color: #336699;
            text-align: center;
            font-weight: bold;
            color: white;
        }
        table.servicesT td.servSHd{	
            border-bottom: 2px solid #6699CC;
            background-color: #336699;
            text-align: left;
            font-weight: bold;
            color: white;
        }

        table.servicesT td{	
            border-bottom: 1px dotted #6699CC;
            color: #404040;
            background-color: white;
            text-align: left;
            padding-left: 3px;
        } 
        .servBodL{
            border-left: 1px dotted #CEDCEA; 
        }
        
    </style>
    
    </head>

    <body onload="loadTourList();">
        <!-- header -->
        <header>
            <div class="container">
                <h1><a href="index.jsp">GeoCaching</a></h1>
                <nav>
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="ListTours.jsp" class="current">Tours</a></li>
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
                                <label id="tourList"></label>
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
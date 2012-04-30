<%-- 
    Document   : index
    Created on : Apr 23, 2012, 4:24:05 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function loadXMLDoc()
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
                    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", "http://localhost:8080/AJAX_JavaWebApp/ChangeTextServlet",true);
            xmlhttp.send();
            }
        </script>
        
        <style type="text/css">
            div.ex
            {
                width:220px;
                height: 50 px;
                padding:10px;
                border:1px solid green;
                margin:0px;
            }
            button.btn
            {
                border: 1px solid  darkgreen; 
                background: darkgreen;
                color:  white;
                cursor: pointer;
            }
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    
    <body>
        
        <h2>This is JSP index page!</h2>
        
        <button class="btn" type="button" onclick="loadXMLDoc()">Add way point</button>
        <br/>
        <div  class="ex" id="myDiv" style="b"><h2>List of way points</h2></div>
        
        
        
    </body>
    
</html>

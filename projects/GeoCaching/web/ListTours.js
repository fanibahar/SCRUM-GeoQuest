function loadTourList()
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
            document.getElementById("tourList").innerHTML=xmlhttp.responseText;
        }
    }
    //for client server use:
    //xmlhttp.open("GET", "http://192.168.0.101:8080/GeoCaching/ListToursServlet",true);
    
    xmlhttp.open("GET", "http://localhost:8080/GeoCaching/ListToursServlet",true);
    xmlhttp.send();
}
<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="com.sgc.model.Login"
         %>

<html>

    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=windows-1256">
        <title>   User Logged Successfully   </title>
    </head>

    <body>
      
    <center>
    <%Login currentUser = (Login)(session.getAttribute("login"));%>
    <p> very good</p>
   
    </center>
    </body>


</html>
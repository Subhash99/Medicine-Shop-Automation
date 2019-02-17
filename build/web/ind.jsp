<%-- 
    Document   : ind.jsp
    Created on : Mar 29, 2018, 4:26:46 AM
    Author     : Subash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("log",""); 
            response.sendRedirect("index.html");
        %>
    </body>
</html>

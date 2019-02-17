<%-- 
    Document   : buy4
    Created on : Mar 30, 2018, 11:01:45 AM
    Author     : Subash
--%>

<%@page import="java.sql.*"%>
<%@ include file="header.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String log=(String)session.getAttribute("log");
    if(!(log.equals("yes")))
    {
        response.sendRedirect("index.html");
        
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1  style="margin-left: 500px"><it><font color="cyan">Successfully Ordered<br>       Thank You</font></it></h1>
    </body>
</html>
<%@ include file="footer.html" %>

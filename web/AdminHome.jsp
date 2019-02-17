<%-- 
    Document   : AdminHome
    Created on : Apr 20, 2018, 8:38:52 PM
    Author     : Subash
--%>
<%@ include file="Aheader.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <button onclick="window.location.href='AdminMed.jsp'" style="margin-left: 100px;margin-top: 250px;">View Medicines</button>
            <button onclick="window.location.href='AdminMedAdd.jsp'"style="margin-left: 700px;">Add Medicines</button><br><br><br><br>
            <button style="margin-left: 500px;">Add Vendors</button>
        </div>
    </body>
</html>
<%@ include file="Afooter.html" %>

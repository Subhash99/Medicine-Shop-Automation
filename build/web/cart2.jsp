<%-- 
    Document   : cart2
    Created on : Mar 31, 2018, 9:18:44 AM
    Author     : Subash
--%>

<%@page import="java.sql.*"%>
<%@ include file="header.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String s=request.getParameter("vid");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            stmt.execute("delete from cart where cart_id="+s);
            response.sendRedirect("cart.jsp");
        %>
    </body>
</html>
<%@ include file="footer.html" %>

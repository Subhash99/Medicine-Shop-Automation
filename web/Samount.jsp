<%-- 
    Document   : amount.jsp
    Created on : Apr 6, 2018, 8:47:58 PM
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
            String n=(String)session.getAttribute("uname");
            String n1=(String)session.getAttribute("muname");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select cost from smedicine where id="+n1);
            rs.next();
            out.print("<b><h3><font style=\"font-family: Courier New;color: #29b3e5;margin-left:500px;\">Total Amount    :"+rs.getInt(1)+"/-</font></h3></b>");
        %>
        <br><br><br>
        <form action="svalidateCard" method="POST">
        <input type="text" name="cardno" placeholder="Card No" style="float:left;margin-left: 500px;border:2px solid cyan;height:30px;width:200px;">
        <input type="text" name="cvv" placeholder="CVV" style="float:left;margin-left: 40px;border:2px solid cyan;height:30px;width:100px;"><br><br>
        <input type="submit"  value="Continue" style="border-radius: 15px;margin-left: 600px;height:40px;margin-top: 50px;;width:150px;background-color: activecaption;">
        </form>
        </body>
</html>
<%@ include file="footer.html" %>

<%-- 
    Document   : buy3.jsp
    Created on : Mar 20, 2018, 9:29:53 AM
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
    <%
            String n=(String)session.getAttribute("muname");
            String n1=(String)session.getAttribute("uname");
        %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <%
                String name,phno,hno,village,mandal,district,state,pincode;
                name=request.getParameter("name");
                phno=request.getParameter("phno");
                hno=request.getParameter("hno");
                village=request.getParameter("village");
                mandal=request.getParameter("mandal");
                district=request.getParameter("dist");
                state=request.getParameter("state");
                pincode=request.getParameter("pincode");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                Statement stmt=con.createStatement();
                Statement stmt2=con.createStatement();
                ResultSet rs1=stmt2.executeQuery("select id from Customer where name=\""+n1+"\"");
                rs1.next();
                ResultSet rs=stmt.executeQuery("select cost from medicine1 where id="+n);
                rs.next();
                Statement stmt1=con.createStatement();
                stmt1.execute("insert into oaddress1 (cid,name,phno,houseno,village,mandal,district,state,pincode,mid) values ("+rs1.getInt(1)+",\""+name+"\",\""+phno+"\",\""+hno+"\",\""+village+"\",\""
                +mandal+"\",\""+district+"\",\""+state+"\",\""+pincode+"\","+n+");");
                
                
             %>
             
             <%
                response.sendRedirect("buy4.jsp");
            %>
            <br>
            
        </div>
    </body>
</html>
<%@ include file="footer.html" %>

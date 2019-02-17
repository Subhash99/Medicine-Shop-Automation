

<%@page import="java.sql.*"%>
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
        <%
            String n=(String)session.getAttribute("muname");
            String n1=(String)session.getAttribute("uname");
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select id from customer where name=\""+n1+"\";");
            rs.next();
            int i=rs.getInt(1);
            stmt.execute("insert into cart (cid,mid)values("+i+","+n+");");
            //response.sendRedirect("");

        %>
    </body>
</html>

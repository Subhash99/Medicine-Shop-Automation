<%-- 
    Document   : Shop_Owner_Viewall_Medicines
    Created on : 10 Apr, 2018, 5:45:44 PM
    Author     : Balachandra
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center"> HELLO SHOP OWNER</h1>
        <h2 align="center">Here is the list of all the Medicines</h2>
        <%
            try
            {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/project","root","root");   
            Statement stmt=con.createStatement(); 
            ResultSet rs=stmt.executeQuery("select * from smedicine;");
            while(rs.next()){
                    out.println("Medicine Id:"+rs.getString(1)+"Medicine name:"+rs.getString(2)+"Vendor address:"+rs.getString(3)+"Manfacture date:"+rs.getString(4)+"Expiry date:"+rs.getString(5)+"Quantity left:"+rs.getString(6)+"<br>");
           
            }
            }
            catch(Exception e)
            {
                
            }
            %>
            <form action="index1.html">
                <input type="Submit" value="LOGOUT" align="center" style="margin-bottom: 20px;background-color: #2f9fe0;height: 30px;width: 80px;border-radius: 17px;"><br>
            </form>
    </body>
</html>

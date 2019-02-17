<%-- 
    Document   : OrderCheckerHome
    Created on : Apr 19, 2018, 2:49:01 PM
    Author     : Subash
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Customer.Customer1"%>
<%@ include file="Sheader.html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            td{
               border:2px solid black;
            }
            </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <%
          try
          {
              String s="<table style=\"border:2px solid black\">";
               Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                PreparedStatement stmt=con.prepareStatement("select * from oaddress1");
                PreparedStatement stmt1=con.prepareStatement("select oid from approves");
                
                ResultSet rs=stmt.executeQuery();
                s=s+"<tr><td>Oid</td><td>Cid</td><td>Mid</td><td>Status</td></tr>";
                while(rs.next())
                {
                    ResultSet rs1=stmt1.executeQuery();
                    int i=5;
                    while(rs1.next())
                    {
                        if(rs.getInt(1)==rs1.getInt(1))
                        {
                            i=0;
                            break;
                        }
                    }
                    if(i==5)
                    {
                        s=s+"<tr style=\"border:2px solid black\"><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getInt("mid")+"</td>";
                        s=s+"<td><button onclick=\"window.location.href='OcApprove.jsp?vid="+rs.getInt(1)+"'\" > Assign </button></td></tr>";
                    }
                    
                }
                s=s+"</table>";
                out.println(s);
          }
          catch(Exception e)
          {
              
          }
        %>
        </div>
    </body>
</html>
<%@ include file="Sfooter.html" %>

<%-- 
    Document   : CustomerOrder
    Created on : Jun 29, 2018, 3:50:51 PM
    Author     : SubhashSpsd
--%>
<%@page import="Customer.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.html" %>
<!DOCTYPE html>
<html>
   <head>
        <style>
            img{
                width:100%;
                hieght:100%;
                display:inline-block;
            }
            th{
                border: 1px solid black;
                border-color: black;
            }
            table{
                
                border: 1px solid black;
                border-color: black;
            }
            td{
                border: 1px solid black;
                padding-top: 10px;
                border-color: black;
                padding-left: 30px;
                padding-right: 30px;
                width:40px;
                hieght:40px;
                padding-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <%
            String s="";
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                Statement stmt=con.createStatement();
                Customer1 c=new Customer1();
                LinkedList<Integer> i=new LinkedList<>();
                i=c.viewOrders();
                Iterator<Integer> itr=i.iterator();
                %>
                <table>

                <%
                    
                while(itr.hasNext())
                {
                     int k=itr.next();
                     s=s+"<tr>";
                     ResultSet rs=stmt.executeQuery("select mid,status from oaddress1 where oid="+k+";");
                     rs.next();
                     s=s+"<td>";
                     s=s+"<img src=\"Medicines\\"+rs.getInt(1)+".jpg\">";
                     s=s+"</td>";
                     s=s+"<td>";
                     s=s+k;
                     s=s+"</td>";
                     s=s+"<td>";
                     s=s+rs.getString("status");
                     s=s+"</td>";
                     s=s+"</tr>";
                     
                     out.print(s);
                }
            }
            catch(Exception e)
            {

            }
            out.print(s);
            
        %>
        
            </table>
    </body>
</html>
<%@ include file="footer.html" %>

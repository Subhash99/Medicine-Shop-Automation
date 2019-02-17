<%-- 
    Document   : buy
    Created on : Mar 11, 2018, 10:17:31 PM
    Author     : Subash
--%>
<%@ include file="Sheader.html" %>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div style="width: 50%; height: 90%;float:left">
            <%
                String id=request.getParameter("vid");
                session.setAttribute("muname",id);
                out.println("<img src=\"Medicines\\"+id+".jpg \" style=\"width:220px;height:180px;margin-left :130px;\">");

            %>
            <br>
            <br>

            </div>
            <div  style="width: 50%; height: 90%;float:right">
                <% 
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                        PreparedStatement stmt=con.prepareStatement("select name,quantity,cost from smedicine where id="+id);
                        ResultSet rs=stmt.executeQuery();
                        rs.next();
                        %>
                        <p style="font-size: 30px;">
                            <font color="#226de5"><i><b>
                        <%
                        out.print("Name : "+rs.getString(1)+"<br>");
                        out.print("Quantity Left : "+rs.getInt(2)+"<br>");
                        out.print("Cost : "+rs.getInt(3)+" Rs/-");
                        rs.close();
                        stmt.close();
                        con.close();
                    }
                    catch(Exception e)
                    {

                    }

                        %>
                 </b></i>
                </font>
                </p>
                <br>
            <button style="width: 200px;height: 30px;border-radius: 15px;background-color: activecaption;margin-top: 95px;s" onclick="window.location.href='Samount.jsp'">Continue</button>
            </div>
        </div>
                 <br><br><br><br>
            
        
    </body>
</html>


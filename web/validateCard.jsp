<%-- 
    Document   : validateCard
    Created on : Apr 7, 2018, 9:02:25 AM
    Author     : Subash
--%>

<%@page import="Customer.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try
            {
                //String n1=(String)session.getAttribute("muname");
                String cardNo=request.getParameter("cardno");
                
                String Cvv=request.getParameter("cvv");
                
                Customer c=new Customer();
                boolean i=c.validateAmount(cardNo,Cvv,"9");
                if(i)
                {
                    response.sendRedirect("buy2.jsp");
                }
                else
                {
                    out.println("Invalid Card or In Sufficient balance");
                    out.println("<jsp:include page=\"amount.jsp\"/>");



                }
            }
            catch(Exception e)
            {
                
            }
        %>
    </body>
    
</html>

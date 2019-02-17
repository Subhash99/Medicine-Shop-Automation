<%-- 
    Document   : OcApprove
    Created on : Apr 19, 2018, 3:47:54 PM
    Author     : Subash
--%>

<%@page import="Customer.OrderChecker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id=request.getParameter("vid");
            OrderChecker r=new OrderChecker();
            boolean b=r.approves(id);
            if(b)
            {
                response.sendRedirect("OrderCheckerHome.jsp");
            }
            else
            {
                
            }
        %>
    </body>
</html>

<%@page import="java.sql.*"%>
<%@ include file="Sheader.html" %>
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
    </head>
    <body>
        <h3><font style="height: 250px;font-family: Courier New;margin-left: 70px;color: #29b3e5">Enter Your Address Details :</font><br></h3>
        <div>
            <form action="soaddress" method="POST">
                <input type="text" name="name" placeholder="Name" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="phno" placeholder="Phone Number" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="hno" placeholder="House No" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="village" placeholder="Village" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="mandal" placeholder="Mandal" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="dist" placeholder="District" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="state" placeholder="State" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="text" name="pincode" placeholder="Pincode" style="margin-left: 515px;width:220px;border-radius: 3px;float:left;"><br><br>
                <input type="submit" value="Confirm Order" style="margin-left: 500px;border-radius: 10px;height:35px;width:250px;background-color: activecaption;">

            </form>
            </div>
    </body>
</html>
<%@ include file="Sfooter.html" %>

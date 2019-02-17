<%-- 
    Document   : AdminMedAdd
    Created on : Apr 20, 2018, 9:16:47 PM
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
        <form action="AdminAddMedicine" method="post">
        <div align="Center">
        <input type="text" name="mid" align="center" placeholder="Medicineid" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="mname" align="center" placeholder="Medicine Name" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="mquantity" align="center" placeholder="Medicine Quantity" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="mdate" align="center" placeholder="Medicine Manifacture Date" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="edate" align="center" placeholder="Medicine Expiry Date" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="mcost" align="center" placeholder="MedicineCost" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="text" name="maddress" align="center" placeholder="Medicine Address" style="background-color: lightblue;margin-bottom: 10px;width: 250px;height: 20px;border-radius: 17px;"><br>
        <input type="submit" value="continue">
        </div>
        </form>
    </body>
</html>

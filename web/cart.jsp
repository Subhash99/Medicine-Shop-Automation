<%@page import="java.sql.*"%>
<%
    String log=(String)session.getAttribute("log");
    if(!(log.equals("yes")))
    {
        response.sendRedirect("index.html");
        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            div.container {
                width: 100%;
                border-radius: 5px;
                border-bottom: 0px;
            }

            header {
                padding: 1px;
                border-radius: 5px;
                color: white;
                background-color: #48c2f2;
                clear: left;
                text-align: center;
                
            }
            footer {
                padding: 1px;
                margin-top: 100px;
                border-radius: 5px;
                color: white;
                margin-bottom: 0px;
                background-color: #48c2f2;
                clear: left;
                text-align: center;
                
            }

            nav {
                float: left;
                max-width: 100px;
                margin: 0;
                padding: 1em;
            }

            nav ul {
                list-style-type: none;
                padding: 0;
            }

            nav ul a {
                text-decoration: none;
            }
            article {
                padding: 1em;
                overflow: hidden;
            }
            table,th{
                border: 1px solid white;
            }
            td{
                border: 1px solid cyan;
                width:130px;
                hieght:90px;
                padding:20px;
            }
            .con{
                width:230px;
                hieght:50px;
                padding-bottom: 50px;

            }
            input[type="text"]{
                background-color: activecaption;
                width:100%;
                height:30px;
                 border:none;
                border-radius: none;
                width:20%;
                float: right;
                height:20px;
                color: white;
                align-self: center;
                color: white;
                border-radius: 5px;
            }
            input.cov{
                border:none;
                border-radius: 5px;
                background-color: #23efb2;
                float:right;
                width:3%;
                height:22px;
                color: white;
            }
            button{
                background-color: activecaption;
                width:100%;
                height:30px;
                color: white;
                border-radius: 15px;
            }
            input.cov1{
                border:none;
                border-radius: 5px;
                background-color: #23efb2;
                float:left;
                width:3%;
                height:22px;
                color: white;
            }
            

        </style>
    </head>
    <body style="width:99%;height:100%;">
        <%
            String n=(String)session.getAttribute("uname"); 
            session.setAttribute("user",n);
        %>
        <div class="container">
            <header>
                <h1><i>Medicine Shop Automation</i><a href="cart.jsp"><img src="cart.png" style="width: 60px;height:30px;float:right;margin-top: 0px;margin-right: 29px;"></a></h1>
            </header>
            <article>
                <input class=cov type="button" onclick="window.location.href='ind.jsp'" value="Logout" style="width:70px;margin-left: 20px;text-align: center">
                <input class=cov1 type="button" onclick="window.location.href='ifr.jsp'" value="Home" style="width:70px;margin-left: 20px;text-align: center">
                <br><br><br>
                <table>
                    <%
                        String s="";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                        Statement stmt=con.createStatement();
                        Statement stmt1=con.createStatement();
                        ResultSet rs1=stmt1.executeQuery("select id from customer where name=\""+n+"\"");
                        rs1.next();
                        int k=rs1.getInt(1);
                        ResultSet rs=stmt.executeQuery("select mid from cart where cid="+k);
                        while(rs.next())
                        {
                            s=s+"<tr>";
                            s=s+"<td>";
                            s=s+"<img src=\"Medicines\\"+rs.getInt(1)+".jpg\" style=\"width:100px;height:60px;\"><br>";
                            s=s+"</td>";
                            s=s+"<td>";
                            rs1=stmt1.executeQuery("select name from medicine1 where id="+rs.getInt(1));
                            rs1.next();
                            s=s+rs1.getString(1);
                            s=s+"</td>";
                            s=s+"<td>";
                            s=s+"<button  onclick=\"window.location.href='buy.jsp?vid="+rs.getInt(1)+"'\" > Proceed to Order </button>";
                            s=s+"</td>";
                            ResultSet rs2=stmt1.executeQuery("select cart_id from cart where mid="+rs.getInt(1)+" and cid="+k);
                            rs2.next();
                            s=s+"<td>";
                            s=s+"<button  onclick=\"window.location.href='cart2.jsp?vid="+rs2.getInt(1)+"'\" > Remove from Cart </button>";
                            s=s+"</td>";
                            s=s+"</tr>";
                            }
                        out.println(s);
                        %>
                </table>
            </article>
            <footer >Copyright &copy; SubhashSpsd</footer>
        </div>

    </body>
</html>
   

















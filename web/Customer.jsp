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
                border: 2px solid #48c2f2;
                border-bottom: 0px;
            }

            header, footer {
                padding: 1px;
                border-radius: 5px;
                color: white;
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
                margin-left: 102px;
                border-left: 2px solid #48c2f2;
                padding: 1em;
                overflow: hidden;
            }
            /*img{
                width:100%;
                hieght:100%;
                display:inline-block;
            }*/
            table,th{
                border: 1px solid black;
                border-color: white;
            }
            td{
                padding-top: 10px;
                width:230px;
                hieght:150px;
                padding-bottom: 5px;
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
             input.cov1{
                border:none;
                border-radius: 5px;
                background-color: #23efb2;
                float:left;
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
            

        </style>
    </head>
    <body style="width:99%;height:100%;">
        <%
            String n=(String)session.getAttribute("uname"); 
            session.setAttribute("user",n);
        %>
        <div class="container">
            <header>
                <h1><i>Medicine Shop Automation</i><a href="Dummy.jsp"><img src="cart.png" style="width: 60px;height:30px;float:right;margin-top: 0px;margin-right: 29px;"></a></h1>
            </header>
            <nav>
              <ul>
                  
              </ul>
            </nav>
            <article>
                <input class=cov type="button" onclick="window.location.href='ind.jsp'" value="Logout" style="width:70px;margin-left: 20px;text-align: center">
                <form action="Search.jsp">
                <input class=cov type="submit" value="go" style="margin-left: 5px">
                <input  type="text" name="search" placeholder="Search Here">
                </form>
                <input class=cov1 type="button" onclick="window.location.href='Customer.jsp'" value="Home" style="width:70px;margin-left: 20px;text-align: center">
                
                <br><br><br>
                <iframe src="ifr.jsp" style="width: 100%;height:430px;border:1px solid white;margin-top: 0px;">
                </iframe>
                
            </article>
            <footer >Copyright &copy; SubhashSpsd</footer>
        </div>

    </body>
</html>
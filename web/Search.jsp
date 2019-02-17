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
    <%
            String n=(String)session.getAttribute("uname"); 
        %>

    <head>
        <style>
            div.container {
                width: 100%;
                border-radius: 5px;
            }

            header, footer {
                padding: 1px;
                color: white;
                background-color: #48c2f2;
                clear: left;
                text-align: center;
                
            }

            
            article {
                padding: 1em;
                overflow: hidden;
            }
            img{
                width:100%;
                hieght:100%;
                display:inline-block;
            }
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
    <body>

        <div class="container">
            <header>
                <h1><i>Spsd Pharmacies</i></h1>
            </header>
            
            <article>
                <input class=cov type="button" onclick="window.location.href='ind.jsp'" value="Logout" style="width:70px;margin-left: 20px;text-align: center">
            
            <input class=cov1 type="button" onclick="window.location.href='ifr.jsp'" value="Home" style="width:70px;margin-left: 20px;text-align: center">
                <br><br><br>
                <h3><font color="cyan">Searched Results..........</font></h3><br><br>
                
                <%
                    try
                    {
                        int []codeno=new int[5];
                        int i,j;
                        String s="";
                        String name=request.getParameter("search");
                        if(name.length()>0)
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                            PreparedStatement stmt=con.prepareStatement("select id,name from medicine1");
                            ResultSet rs=stmt.executeQuery();
                            s=s+"<table>";
                            while(rs.next())
                            {

                                if(rs.getString(2).contains(name))
                                {
                                    s=s+"<tr>";
                                            for(i=0;i<5;i++)
                                            {
                                                codeno[i]=rs.getInt(1);
                                                s=s+"<td>";
                                                s=s+"<img src=\"Medicines\\"+rs.getInt(1)+".jpg\">";
                                                s=s+"</td>";
                                                if(!(rs.next()))
                                                {
                                                    i++;
                                                    break;
                                                }
                                            }
                                            s=s+"</tr>";
                                            s=s+"<tr>";
                                            for(j=0;j<i;j++)
                                            {
                                                s=s+"<td class=con>";
                                                s=s+"<button  onclick=\"window.location.href='buy.jsp?vid="+codeno[j]+"'\" > Buy </button>";
                                                s=s+"</td>";
                                            }
                                            s=s+"</tr>";
                                }
                            }
                            s=s+"</table>";
                            out.println(s);
                        }   
                    }
                    catch(Exception e)
                    {

                    }
                %>
                
            </article>
            <footer>Copyright &copy; SubhashSpsd</footer>
        </div>

    </body>
</html>
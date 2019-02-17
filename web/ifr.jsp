<%@page import="java.util.*"%>
<%@page import="Customer.Customer1"%>
<%@page import="java.sql.*"%>
<%@ include file="header.html" %>
<!DOCTYPE html>
<%
    String log=(String)session.getAttribute("log");
    if(!(log.equals("yes")))
    {
        response.sendRedirect("index.html");
        
    }
%>
<html>
    <%
            String n=(String)session.getAttribute("uname"); 
        %>

    <head>
        <style>
            div.container {
                width: 100%;
                border-radius: 5px;
                border: 1px solid white;
            }

            header{
                padding: 1px;
                color: white;
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
                padding-left: 30px;
                padding-right: 30px;
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
            

        </style>
    </head>
    <body>
        <div class="container">
                <%
                    try
                    {
                        
                        int i=0,j=0;
                        String s="<table>";
                        int [] codeno=new int[5];
                        Customer1 c=new Customer1();
                        LinkedList <Integer> li=c.view();
                        Iterator<Integer> itr=li.iterator();  
                        while(itr.hasNext())
                        {  
                            s=s+"<tr>";
                            for(i=0;i<5;i++)
                            {
                                codeno[i]=itr.next();
                                s=s+"<td>";
                                s=s+"<img src=\"Medicines\\"+codeno[i]+".jpg\">";
                                s=s+"</td>";
                                if(!(itr.hasNext()))
                                {
                                    i++;
                                    break;
                                }
                            }
                            s=s+"</tr>";
                            s=s+"<tr>";
                            for(j=0;j<i;j++)
                            {
                                s=s+"<td class=\"con\">";
                                s=s+"<button  onclick=\"window.location.href='buy.jsp?vid="+codeno[j]+"'\" > Buy </button>";
                                s=s+"</td>";
                            }
                            s=s+"</tr>";
                        }
                        out.print(s+"</table>");
                    }
                    catch(Exception e)
                    {
                        out.println(e);
                    }
                %> 
        </div>
    </body>
</html>
<%@ include file="footer.html" %>
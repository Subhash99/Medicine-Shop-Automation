<%-- 
    Document   : Shop_Owner_Home
    Created on : 10 Apr, 2018, 2:21:04 PM
    Author     : Balachandra
--%>
<%@ include file="Sheader.html" %>
<%@page import="Customer.Shop_Owner"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Customer.Customer1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
    </head>
    <body>
        <h1 align="center"> HELLO SHOP OWNER</h1>
        <h2 align="center">Medicines whose quantity is below the Threshold value</h2>
        <%
           try
                    {
                        
                        int i=0,j=0;
                        String s="<table>";
                        String [] codeno=new String[5];
                        Shop_Owner c=new Shop_Owner();
                        LinkedList <String> li=c.view();
                        Iterator<String> itr=li.iterator();  
                        while(itr.hasNext())
                        {  
                            s=s+"<tr>";
                            for(i=0;i<5;i++)
                            {
                                codeno[i]=itr.next();
                                s=s+"<td>";
                                s=s+"<img src=\"Medicine2\\"+codeno[i]+".jpg\">";
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
                                s=s+"<button  onclick=\"window.location.href='Sbuy.jsp?vid="+codeno[j]+"'\" > Buy </button>";
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
            <form action="Shop_Owner_Viewall_Medicines.jsp" method="post">
                <input type="Submit" value="VIEW_ALL" align="center" style="margin-bottom: 20px;background-color: #2f9fe0;height: 30px;width: 80px;border-radius: 17px;margin-left: 500px;"><br>
            </form>
            <br>
            
    </body>
</html>
<%@ include file="Sfooter.html" %>

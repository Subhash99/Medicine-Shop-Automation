import Customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class svalidateCard extends HttpServlet
{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        HttpSession session=request.getSession(false);
        String log=(String)session.getAttribute("log");
        if(!(log.equals("yes")))
        {
            response.sendRedirect("index.html");
        }
        PrintWriter out=response.getWriter();
        
        try
            {
                
                String n1=(String)session.getAttribute("muname");
                String cardNo=request.getParameter("cardno");
                session.setAttribute("cardNo",cardNo);
                
                String Cvv=request.getParameter("cvv");
                if(Cvv.isEmpty() || cardNo.isEmpty())
                {
                    response.sendRedirect("Samount.jsp");
                }
                
                Shop_Owner s=new Shop_Owner();
                boolean i=s.validateAmount(cardNo,Cvv,n1);
                if(i)
                {
                    response.sendRedirect("Sbuy2.jsp");
                }
                else
                {
                    response.sendRedirect("Samount.jsp");
                }
            }
            catch(Exception e)
            {
                out.print(e);
            }
    }
    
}
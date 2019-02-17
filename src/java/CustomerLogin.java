import Customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CustomerLogin extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        
        try
        {
            PrintWriter out=res.getWriter();
            
            String uname=req.getParameter("uname");
            String pword=req.getParameter("pword");
            
            HttpSession session=req.getSession();
            session.setAttribute("uname",uname);
            
            Customer1 cust=new Customer1();
            boolean i=cust.login(uname,pword);
            
            
            if(i)
            {
                HttpSession session1=req.getSession();
                session1.setAttribute("log","yes");
                 res.sendRedirect("ifr.jsp");
            }
            else
            {
                out.println("<h4  align=\"center\"><font color=\"red\">Invalid UserName or Password</font></h4>");
                RequestDispatcher rd=req.getRequestDispatcher("index2.html");
                rd.include(req, res);
            }
        }
        catch(IOException | ServletException e)
        {
            
        }
    }
}

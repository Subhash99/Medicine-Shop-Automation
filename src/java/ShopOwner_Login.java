import Customer.Shop_Owner;
import customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShopOwner_Login extends HttpServlet
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
            
            Shop_Owner so;
            so = new Shop_Owner();
            boolean i=so.Login(uname,pword);
            
            
            if(i)
            {
                HttpSession session1=req.getSession();
                session1.setAttribute("log","yes");
                res.sendRedirect("Shop_Owner_Home.jsp");
            }
            else
            {
                out.println("<h4  align=\"center\"><font color=\"red\">Invalid UserName or Password</font></h4>");
                RequestDispatcher rd=req.getRequestDispatcher("index1.html");
                rd.include(req, res);
            }
        }
        catch(IOException | ServletException e)
        {
            
        }
    }
}
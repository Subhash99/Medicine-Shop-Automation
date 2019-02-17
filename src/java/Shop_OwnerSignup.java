import Customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
public class Shop_OwnerSignup extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        try
        {
            PrintWriter out=res.getWriter();
            
            String uname=req.getParameter("uname");
            String pword=req.getParameter("pword");
            String id=req.getParameter("id");
            String mob=req.getParameter("mobno");
            String address=req.getParameter("address");
            
            HttpSession session=req.getSession();
            session.setAttribute("uname",uname);
            
            Shop_Owner so;
            so = new Shop_Owner();
            boolean i=so.Register(uname,pword,mob,address,id);
            
            
            if(i)
            {
                HttpSession session1=req.getSession();
                session1.setAttribute("log","yes");
                res.sendRedirect("index1.html");
            }
            else
            {
                out.println("<h4  align=\"center\"><font color=\"red\">Invalid UserName or Password</font></h4>");
                RequestDispatcher rd=req.getRequestDispatcher("Shop_OwnerRegister.jsp");
                rd.include(req, res);
            }
        }
        catch(IOException | ServletException e)
        {
            
        }
    }
}
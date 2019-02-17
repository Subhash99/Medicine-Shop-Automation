import Customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class OrderCheckerLogin extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        PrintWriter out=res.getWriter();
        String uname=req.getParameter("uname");
        String pword=req.getParameter("pword");
        OrderChecker r=new OrderChecker();
        boolean b=r.login(uname, pword);
        if(b)
        {
            res.sendRedirect("OrderCheckerHome.jsp");
        }
        else
        {
            out.println("<h4  align=\"center\"><font color=\"red\">Invalid UserName or Password</font></h4>");
                RequestDispatcher rd=req.getRequestDispatcher("index4.html");
                rd.include(req, res);
        }
    }
}
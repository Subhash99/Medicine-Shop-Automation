import Customer.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminSignUp extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        
        try
        {
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            
            
            
                    
            String id=req.getParameter("id");
            String uname=req.getParameter("uname");
            String pword=req.getParameter("pword");
            String p1word=req.getParameter("p1word");
            String mobno=req.getParameter("mobno");
            Admin a=new Admin();
            boolean c=a.signUp(id, uname, pword, p1word, mobno);
            if(c)
            {
            }
            else {
                out.println("<h3 align=\"center\"><font color=\"red\">Pasword fields misMatched <br>Try Again</font><h3><br>");
                RequestDispatcher rd=req.getRequestDispatcher("cregister.html");
                rd.include(req, res);
            }
        }
        catch(Exception e)
        {
            
        }
    }
}
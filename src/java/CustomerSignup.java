import Customer.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CustomerSignup extends HttpServlet
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
            String address=req.getParameter("address");
            String mobno=req.getParameter("mobno");
            Customer1 cus=new Customer1();
            boolean c=cus.signUp(id, uname, pword, p1word, address, mobno);
            if(c)
            {
                out.println("<h3 align=\"center\"><font color=\"green\">Registered Successfully <br>Login</font><h3><br>");
                 RequestDispatcher rd=req.getRequestDispatcher("index1.html");
                 rd.include(req, res);
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
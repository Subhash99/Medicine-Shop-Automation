import Customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class oaddress extends HttpServlet
{
    @Override
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
        String n=(String)session.getAttribute("muname");
        String cardNo=(String)session.getAttribute("cardNo");
        String n1=(String)session.getAttribute("uname");
        try
        {
            String name,phno,hno,village,mandal,district,state,pincode;
            name=request.getParameter("name");
            phno=request.getParameter("phno");
            hno=request.getParameter("hno");
            village=request.getParameter("village");
            mandal=request.getParameter("mandal");
            district=request.getParameter("dist");
            state=request.getParameter("state");
            pincode=request.getParameter("pincode");
            Customer1 c=new Customer1();
            boolean i=c.order(n,n1,name,phno,hno,village,mandal,district,state,pincode,cardNo);
            if(i)
            {
                response.sendRedirect("buy4.jsp");
            }
            else
            {
                response.sendRedirect("buy2.jsp");
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
}
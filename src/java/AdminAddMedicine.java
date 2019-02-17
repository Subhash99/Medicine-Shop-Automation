import Customer.Admin;
import Customer.Shop_Owner;
import customer.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminAddMedicine extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        PrintWriter out=res.getWriter();
        String mid=req.getParameter("mid");
        String mname=req.getParameter("mname");
        String mquantity=req.getParameter("mquantity");
        String mdate=req.getParameter("mdate");
        String edate=req.getParameter("edate");
        String mcost=req.getParameter("mcost");
        String maddress=req.getParameter("maddress");
        
        Admin a=new Admin();
        boolean b=a.addMedicine(mid,mname,mquantity,mdate,edate,mcost,maddress);
        if(b)
        {
            out.println("Successfully Updated");
        }
        else
        {
            out.println("Unsuccessfull");
        }
    }
    
}
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class buy2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    String log=(String)session.getAttribute("log");
    if(!(log.equals("yes")))
    {
        response.sendRedirect("index.html");
        
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    ");

            String n=(String)session.getAttribute("uname");
            String n1=(String)session.getAttribute("muname");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select cost from medicine1 where id="+n1);
            rs.next();
        
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h3><font style=\"height: 250px;font-family: Courier New;margin-left: 70px;color: #29b3e5\">Enter Your Address Details :</font><br></h3>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <form action=\"buy3.jsp\">\n");
      out.write("                <input type=\"text\" name=\"name\" placeholder=\"Name\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"phno\" placeholder=\"Phone Number\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"hno\" placeholder=\"House No\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"village\" placeholder=\"Village\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"mandal\" placeholder=\"Mandal\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"dist\" placeholder=\"District\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"state\" placeholder=\"State\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("                <input type=\"text\" name=\"pincode\" placeholder=\"Pincode\" style=\"width:220px;border-radius: 3px;\"><br><br>\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("            ");
out.print("<b><font style=\"font-family: Courier New;color: #29b3e5;margin-left:500px;\">Total Amount    :"+rs.getInt(1)+"/-</font></b>");
      out.write("<br><br>\n");
      out.write("        <button onclick=\"window.location.href='buy4.jsp'\" style=\"margin-left: 500px;border-radius: 10px;height:35px;width:250px;background-color: activecaption;\">Confirm Order</button>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

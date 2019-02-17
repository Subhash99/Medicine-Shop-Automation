package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class buy4_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/footer.html");
  }

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            div.container {\n");
      out.write("                width: 100%;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border-bottom: 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            header{\n");
      out.write("                padding: 1px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                color: white;\n");
      out.write("                background-color: #48c2f2;\n");
      out.write("                clear: left;\n");
      out.write("                text-align: center;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            article {\n");
      out.write("                padding: 1em;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            table,th{\n");
      out.write("                border: 1px solid black;\n");
      out.write("                border-color: white;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                padding-top: 10px;\n");
      out.write("                width:230px;\n");
      out.write("                hieght:150px;\n");
      out.write("                padding-bottom: 5px;\n");
      out.write("            }\n");
      out.write("            .con{\n");
      out.write("                width:230px;\n");
      out.write("                hieght:50px;\n");
      out.write("                padding-bottom: 50px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"]{\n");
      out.write("                background-color: activecaption;\n");
      out.write("                width:100%;\n");
      out.write("                height:30px;\n");
      out.write("                 border:none;\n");
      out.write("                border-radius: none;\n");
      out.write("                width:20%;\n");
      out.write("                float: right;\n");
      out.write("                height:20px;\n");
      out.write("                color: white;\n");
      out.write("                align-self: center;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            input.cov{\n");
      out.write("                border:none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                background-color: #23efb2;\n");
      out.write("                float:right;\n");
      out.write("                width:3%;\n");
      out.write("                height:22px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("             input.cov1{\n");
      out.write("                border:none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                background-color: #23efb2;\n");
      out.write("                float:left;\n");
      out.write("                width:3%;\n");
      out.write("                height:22px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            button{\n");
      out.write("                background-color: activecaption;\n");
      out.write("                width:100%;\n");
      out.write("                height:30px;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 15px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"width:99%;height:100%;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <header>\n");
      out.write("                <h1><i>Medicine Shop Automation</i><a href=\"cart2.jsp\"><img src=\"cart.png\" style=\"width: 70px;height:50px;float:right;margin-top: 0px;margin-right: 20px;\"><a href=\"CustomerOrder.jsp\"><img src=\"orders.png\" style=\"width: 70px;height:50px;float:right;margin-top: 0px;margin-right: 20px;\"></a></a></h1>\n");
      out.write("            </header>\n");
      out.write("                    <article>\n");
      out.write("            <input class=cov type=\"button\" onclick=\"window.location.href='ind.jsp'\" value=\"Logout\" style=\"width:70px;margin-left: 20px;text-align: center\">\n");
      out.write("            <form action=\"Search.jsp\">\n");
      out.write("            <input class=cov type=\"submit\" value=\"go\" style=\"margin-left: 5px\">\n");
      out.write("            <input  type=\"text\" name=\"search\" placeholder=\"Search Here\">\n");
      out.write("            </form>\n");
      out.write("            <input class=cov1 type=\"button\" onclick=\"window.location.href='ifr.jsp'\" value=\"Home\" style=\"width:70px;margin-left: 20px;text-align: center\">\n");
      out.write("\n");
      out.write("            <br><br><br>\n");
      out.write("            </article>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    String log=(String)session.getAttribute("log");
    if(!(log.equals("yes")))
    {
        response.sendRedirect("index.html");
        
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1  style=\"margin-left: 400px\"><it>Successfully Ordered</it></h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            footer {\n");
      out.write("                padding: 1px;\n");
      out.write("                margin-top: 100px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                color: white;\n");
      out.write("                background-color: #48c2f2;\n");
      out.write("                clear: left;\n");
      out.write("                text-align: center;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <footer >Copyright &copy; SubhashSpsd</footer>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write('\n');
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

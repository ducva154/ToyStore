package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import Entity.ProductType;
import java.util.HashMap;
import Entity.Product;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Toy World</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <script src=\"js/script.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/d9b045063b.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"clear\"></div>\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div class=\"about-us\">\n");
      out.write("                <h3>About Us</h3>\n");
      out.write("                <p>Nam libero tempore, cum soluta nobis est eligendi \n");
      out.write("                    optio cumque nihil impedit quo minus id quod maxime \n");
      out.write("                    placeat facere possimus.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"services\">\n");
      out.write("                <h3>Customer Services</h3>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\">Shipping</a></li>\n");
      out.write("                    <li><a href=\"#\">Terms & Conditions</a></li>\n");
      out.write("                    <li><a href=\"#\">Faqs</a></li>\n");
      out.write("                    <li><a href=\"#\">Contact</a></li>\n");
      out.write("                    <li><a href=\"#\">Online Shopping</a></li>\t\t\t\t\t\t \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"address\">\n");
      out.write("                <h3>Connect with us</h3>\n");
      out.write("                <p><i class=\"fas fa-address-card\"> </i> 12K Street , 45 Building Road Viet Nam.</p>\n");
      out.write("                <p><i class=\"fas fa-phone-alt\"> </i> +1234 758 839 , +1273 748 730</p>\t\n");
      out.write("                <p><i class=\"fas fa-envelope\"></i> <a href=\"mailto:info@example.com\">info@example1.com</a></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

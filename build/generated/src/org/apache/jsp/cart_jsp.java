package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <style>\n");
      out.write("            table{\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 1170px;\n");
      out.write("            }\n");
      out.write("            table, th, td {\n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            table .product-img img{\n");
      out.write("                max-width: 100px;\n");
      out.write("            }\n");
      out.write("            table .product-name{\n");
      out.write("                width: 350px;\n");
      out.write("                padding-left: 20px;\n");
      out.write("            }\n");
      out.write("            table .product-img{\n");
      out.write("                width: 120px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table .product-number{\n");
      out.write("                width: 50px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table .product-price{\n");
      out.write("                width: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table .product-quantity input{\n");
      out.write("                width: 40px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table .product-quantity{\n");
      out.write("                width: 60px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table .total-money{\n");
      out.write("                width: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #form-button{\n");
      out.write("                text-align: right;\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            .product-delete{\n");
      out.write("                width: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #cart-form label{\n");
      out.write("                width: 100px;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            #cart-form textarea{\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            #cart-form input{\n");
      out.write("                line-height: 30px;\n");
      out.write("                height: 30px;\n");
      out.write("            }\n");
      out.write("            input[name=\"order_click\"]{\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("            #row-total{\n");
      out.write("                background: #eee;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/d9b045063b.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"header-top\">\n");
      out.write("                <ul class=\"header-phone\">\n");
      out.write("                    <li><i class=\"fas fa-phone-alt\"></i> Hotline: 0123 456 789 </li>\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"header-menu\">\n");
      out.write("                    <li><a href=\"#\"><i class=\"fas fa-shopping-cart\"></i> Shopping cart</a></li>\n");
      out.write("                    <li><a href=\"SignupControl\"><i class=\"fas fa-user-plus\"></i> Sign up</a></li>\n");
      out.write("                    <li><a href=\"LoginControl\"><i class=\"fas fa-user\"></i> Log in</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"header-bottom\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"HomeControl\"><img src=\"img/logo.png\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"search-form\">\n");
      out.write("                    <form action=\"SearchControl\" method=\"post\">\n");
      out.write("                        <input type=\"text\" placeholder=\"Search...\" name=\"search\">\n");
      out.write("                        <input type=\"submit\" value=\" \" >\n");
      out.write("                    </form>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-facebook\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-twitch\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-google-plus-square\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-youtube-square\"></i></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"clear\"></div>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <ul class=\"list-menu\">\n");
      out.write("                <li><a href=\"HomeControl\">Home</a></li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"ShowProductControl\">Show products</a>\n");
      out.write("                    <ul class=\"sub-menu\">\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>  \n");
      out.write("        </div>\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <img alt=\"...\" src=\"img/banner.jpg\" height=\"500\" width=\"100%\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"clear\"></div>\n");
      out.write("        <div class=\"main\">\n");
      out.write("            <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("            <form id=\"cart-form\" action=\"cart.php?action=submit\" method=\"POST\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"product-number\">STT</th>\n");
      out.write("                        <th class=\"product-name\">Tên sản phẩm</th>\n");
      out.write("                        <th class=\"product-img\">Ảnh sản phẩm</th>\n");
      out.write("                        <th class=\"product-price\">Đơn giá</th>\n");
      out.write("                        <th class=\"product-quantity\">Số lượng</th>\n");
      out.write("                        <th class=\"total-money\">Thành tiền</th>\n");
      out.write("                        <th class=\"product-delete\">Xóa</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <?php \n");
      out.write("                    $num = 1;\n");
      out.write("                    while ($row = mysqli_fetch_array($products)) { ?>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"product-number\"><?=$num++;?></td>\n");
      out.write("                        <td class=\"product-name\"><?=$row['name']?></td>\n");
      out.write("                        <td class=\"product-img\"><img src=\"<?=$row['image']?>\" /></td>\n");
      out.write("                        <td class=\"product-price\"><?=$row['price']?></td>\n");
      out.write("                        <td class=\"product-quantity\"><input type=\"text\" value=\"<?=$_SESSION[\"cart\"][$row['id']]?>\" name=\"quantity[<?=$row['id']?>]\" /></td>\n");
      out.write("                        <td class=\"total-money\"><?=$row['price']?></td>\n");
      out.write("                        <td class=\"product-delete\">Xóa</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <?php \n");
      out.write("                    $num++;\n");
      out.write("                    } ?>\n");
      out.write("                    <tr id=\"row-total\">\n");
      out.write("                        <td class=\"product-number\">&nbsp;</td>\n");
      out.write("                        <td class=\"product-name\">Tổng tiền</td>\n");
      out.write("                        <td class=\"product-img\">&nbsp;</td>\n");
      out.write("                        <td class=\"product-price\">&nbsp;</td>\n");
      out.write("                        <td class=\"product-quantity\">&nbsp;</td>\n");
      out.write("                        <td class=\"total-money\">2.500.000</td>\n");
      out.write("                        <td class=\"product-delete\">Xóa</td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <div id=\"form-button\">\n");
      out.write("                    <input type=\"submit\" name=\"update_click\" value=\"Cập nhật\" />\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                <div><label>Người nhận: </label><input type=\"text\" value=\"\" name=\"name\" /></div>\n");
      out.write("                <div><label>Điện thoại: </label><input type=\"text\" value=\"\" name=\"phone\" /></div>\n");
      out.write("                <div><label>Địa chỉ: </label><input type=\"text\" value=\"\" name=\"address\" /></div>\n");
      out.write("                <div><label>Ghi chú: </label><textarea name=\"note\" cols=\"50\" rows=\"7\" ></textarea></div>\n");
      out.write("                <input type=\"submit\" name=\"order_click\" value=\"Đặt hàng\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
      out.write("    </div>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hmProductType}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <li><a href=\"ShowProductByType?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.key}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.value.productTypeName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}

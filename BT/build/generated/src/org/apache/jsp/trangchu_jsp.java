package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import dao.hopdong.HopDongDAO;
import model.HopDong;
import java.util.ArrayList;
import constant.Constants;
import model.ThanhVien;

public final class trangchu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"container\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/header.jsp", out, false);
      out.write("\n");
      out.write("            <h2>Danh sách hơp đồng thuê xe</h2>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Khách hàng</th>\n");
      out.write("                        <th>Xe thuê</th>\n");
      out.write("                        <th>Ngày thuê</th>\n");
      out.write("                        <th>Ngày trả</th>\n");
      out.write("                        <th>Lựa chọn</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("            ");

                ServletContext sc = getServletContext();
                HopDongDAO sp = new HopDongDAO();
                List<HopDong> listHopDong = new ArrayList<HopDong>();
                listHopDong = (ArrayList) sc.getAttribute("listHopDong");
                if (listHopDong == null) {
                        listHopDong = sp.getAll();
                }
                sc.removeAttribute("listProduct");
                for (HopDong hd : listHopDong) {
            
      out.write("\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>John</td>\n");
      out.write("                    <td>Doe</td>\n");
      out.write("                    <td>john@example.com</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Mary</td>\n");
      out.write("                    <td>Moe</td>\n");
      out.write("                    <td>mary@example.com</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>July</td>\n");
      out.write("                    <td>Dooley</td>\n");
      out.write("                    <td>july@example.com</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/footer.jsp", out, false);
      out.write("\n");
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

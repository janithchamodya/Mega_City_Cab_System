package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changeAddminData_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Mega City Cab - Dashboard</title>\n");
      out.write("\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <link href=\"css/adminDashboard/fontawesome/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/adminDashboard/mega-city-admin/Mega City Cabadmin.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/loginSignup/login.css\">\n");
      out.write("    <script type=\"text/javascript\" src=\"js/adminManageDashboard/adminManageDashboard.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n");
      out.write("\n");
      out.write("          \n");
      out.write("            <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"index.html\">\n");
      out.write("                <div class=\"sidebar-brand-icon rotate-n-15\">\n");
      out.write("                    <i class=\"fas fa-laugh-wink\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"sidebar-brand-text mx-3\">Mega City Cab</div>\n");
      out.write("            </a>\n");
      out.write("\n");
      out.write("          \n");
      out.write("            <hr class=\"sidebar-divider my-0\">\n");
      out.write("            <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("            <!-- Heading -->\n");
      out.write("            <div class=\"sidebar-heading\">\n");
      out.write("                Interface\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("                    <i class=\"fas fa-fw fa-cog\"></i>\n");
      out.write("                    <span>Facilities</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Admin Management:</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"addAddmin.jsp\">Add Addmin</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"deleteAddmin.jsp\">Delete Addmin</a>\n");
      out.write("                        <a class=\"collapse-item\" href=\"changeAddminDataServlet\">Change Addmin Details</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                    <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                    <span>Super Addmin Controls</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\"\n");
      out.write("                    data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Custom Utilities:</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"\">Super Addmin Change</a>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("            <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("            <!-- Heading -->\n");
      out.write("            <div class=\"sidebar-heading\">\n");
      out.write("                Details\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\"\n");
      out.write("                    aria-expanded=\"true\" aria-controls=\"collapsePages\">\n");
      out.write("                    <i class=\"fas fa-fw fa-folder\"></i>\n");
      out.write("                    <span>Admin Data</span>\n");
      out.write("                </a>\n");
      out.write("                <div id=\"collapsePages\" class=\"collapse\" aria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\n");
      out.write("                    <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                        <h6 class=\"collapse-header\">Display Screens:</h6>\n");
      out.write("                        <a class=\"collapse-item\" href=\"\">Register Details</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <!-- Nav Item - Charts addmin data as chart-->\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"\">\n");
      out.write("                    <i class=\"fas fa-fw fa-chart-area\"></i>\n");
      out.write("                    <span>Charts</span></a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Divider -->\n");
      out.write("            <hr class=\"sidebar-divider d-none d-md-block\">\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <!-- End of Sidebar -->\n");
      out.write("\n");
      out.write("        <!-- Content Wrapper -->\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("            <!-- Main Content -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("\n");
      out.write("                <!-- Topbar -->\n");
      out.write("                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\n");
      out.write("\n");
      out.write("                    <!-- Sidebar Toggle (Topbar) -->\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <!-- Topbar Navbar -->\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("\n");
      out.write("                        <!-- Nav Item - User Information -->\n");
      out.write("                        <li class=\"nav-item dropdown no-arrow\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\"\n");
      out.write("                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">Douglas McGee</span>\n");
      out.write("                                <img class=\"img-profile rounded-circle\"\n");
      out.write("                                    src=\"\">\n");
      out.write("                            </a>\n");
      out.write("                            <!-- Dropdown - User Information -->\n");
      out.write("                            <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"\n");
      out.write("                                aria-labelledby=\"userDropdown\">\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\n");
      out.write("                                    <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                    Logout\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </nav>\n");
      out.write("            <!-- End of Topbar -->\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"container mt-5\">\n");
      out.write("                <h2 class=\"text-center\">Admin Management</h2>\n");
      out.write("                <table class=\"table table-hover\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">Username</th>\n");
      out.write("                            <th scope=\"col\">NIC</th>\n");
      out.write("                            <th scope=\"col\">Phone</th>\n");
      out.write("                            <th scope=\"col\">Email</th>\n");
      out.write("                            <th scope=\"col\">Role</th>\n");
      out.write("                            <th scope=\"col\">Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                       \n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("            <!-- Footer -->\n");
      out.write("            <footer class=\"sticky-footer bg-white\">\n");
      out.write("                <div class=\"container my-auto\">\n");
      out.write("                    <div class=\"copyright text-center my-auto\">\n");
      out.write("                        <span>Copyright &copy; Mega City Cab Website 2025</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("            <!-- End of Footer -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- End of Page Wrapper -->\n");
      out.write("\n");
      out.write("    <!-- Scroll to Top Button-->\n");
      out.write("    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\n");
      out.write("        <i class=\"fas fa-angle-up\"></i>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <!-- Logout Modal-->\n");
      out.write("    <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\n");
      out.write("        aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ready to Leave?</h5>\n");
      out.write("                    <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">×</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">Select \"Logout\" below if you are ready to end your current session.</div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("                    <a class=\"btn btn-primary\" href=\"login.html\">Logout</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("   \n");
      out.write("    <script src=\"js/adminDashboard/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/adminDashboard/bootstrap/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"js/adminDashboard/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("                    ");
 
                        String error = request.getParameter("error");
                        String success = request.getParameter("success");

                        // Show error message if the error parameter is not null
                        if (error != null) { 
                    
      out.write("\n");
      out.write("                        // Call showError function to display error based on the error code\n");
      out.write("                        showError(");
      out.print( error );
      out.write(");\n");
      out.write("                    ");
 
                        } else if (success != null) { 
                    
      out.write("\n");
      out.write("                        // Call showSuccess function if success parameter is present\n");
      out.write("                        showSuccess(");
      out.print( success );
      out.write(");\n");
      out.write("                        changeAddminData();\n");
      out.write("                    ");
 
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write(" </script>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
    _jspx_th_c_forEach_0.setVar("admin");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${adminList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                 <form action=\"changeAddminDataServlet\" method=\"POST\">\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"text\" name=\"username\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"text\" name=\"nic\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.nic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"text\" name=\"phone\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"email\" name=\"email\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"text\" name=\"role\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"form-control\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <button type=\"submit\" class=\"btn btn-primary\">\n");
          out.write("                                            Update\n");
          out.write("                                        </button>\n");
          out.write("                                    </td>\n");
          out.write("                                </form>\n");
          out.write("                            </tr>\n");
          out.write("                        ");
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

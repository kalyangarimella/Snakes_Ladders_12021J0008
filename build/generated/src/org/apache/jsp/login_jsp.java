package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.SL.BLL.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login Page</title>        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"script/login.js\"></script>\t\n");
      out.write("        <script type=\"text/javascript\" src=\"script/jquery.js\"></script>\n");
      out.write("        <script type='text/javascript' src=\"script/jquery.autocomplete.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.autocomplete.css\"/>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $().ready(function() {\n");
      out.write("                $(\"#username\").autocomplete(\"usernames.jsp\", {\n");
      out.write("                    width: 211,\n");
      out.write("                    matchContains: true,\n");
      out.write("                    selectFirst: false\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body bgcolor=\"ghostWhite\">\n");
      out.write("        <div class=\"root\">\n");
      out.write("            <div class=\"siteName\">\n");
      out.write("                <p class=\"websiteName\">Snakes and Ladders Game</p>\n");
      out.write("                <p class=\"tagLine\">A classic online board game and it's fun!</p>\n");
      out.write("            </div>\n");
      out.write("            ");

                if (session.getAttribute("USERNAME") != null) {
            
      out.write("\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <a href=\"index.jsp\" id=\"home\" class=\"home\">Home</a>\n");
      out.write("                <a href=\"instructions.jsp\" id=\"instructions\" class=\"instructions\">Instructions</a>\n");
      out.write("                <a href=\"registration.jsp\" id=\"registration\" class=\"registration\">Create an Account</a>\n");
      out.write("                <a href=\"newGame.jsp\" id=\"createGame\" class=\"createGame\">Create Game</a>\t\t\t\n");
      out.write("                <a href=\"join.jsp\" id=\"join\" class=\"join\">Join Game</a>\n");
      out.write("                <a href=\"contact.jsp\" id=\"contact\" class=\"contact\">Contact Us</a>\n");
      out.write("                <a href=\"logout.jsp\" id=\"logout\" class=\"login\">Logout</a>\n");
      out.write("            </div>\n");
      out.write("            ");
            } else {
            
      out.write("    \n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <a href=\"index.jsp\" id=\"home\" class=\"home\">Home</a>\n");
      out.write("                <a href=\"instructions.jsp\" id=\"instructions\" class=\"instructions\">Instructions</a>\n");
      out.write("                <a href=\"registration.jsp\" id=\"registration\" class=\"registration\">Create an Account</a>\n");
      out.write("                <a href=\"newGame.jsp\" id=\"createGame\" class=\"createGame\">Create Game</a>\t\t\t\n");
      out.write("                <a href=\"join.jsp\" id=\"join\" class=\"join\">Join Game</a>\n");
      out.write("                <a href=\"contact.jsp\" id=\"contact\" class=\"contact\">Contact Us</a>\n");
      out.write("                <a href=\"login.jsp\" id=\"login\" class=\"login\">Sign in</a>\n");
      out.write("            </div>\n");
      out.write("            ");
                }
            
      out.write("\n");
      out.write("            <div id=\"content\" class=\"content\">\n");
      out.write("\n");
      out.write("                <form action=\"DataController\" id=\"regForm\" class=\"regForm\" method=\"get\" onSubmit=\"return checkLogin();\">\n");
      out.write("                    <fieldset class=\"loginFieldset\">\n");
      out.write("                        <legend class=\"legendFont\">Sign In</legend>\n");
      out.write("                        <table>\n");
      out.write("                            <tr><td class=\"formtr\">User Name<font color=\"red\">*</font></td><td class=\"formtr\"><input type=\"text\" size=\"30\" name=\"username\" id=\"username\" placeholder=\"Enter User Name\"></td></tr>\n");
      out.write("                            <tr><td class=\"formtr\">Password<font color=\"red\">*</font></td><td class=\"formtr\"><input type=\"password\" size=\"30\" name=\"password\" id=\"password\" placeholder=\"Enter Password\"></td></tr>\n");
      out.write("                            <tr><td></td><td></td></tr><tr><td></td><td></td></tr>\n");
      out.write("                            <tr><td><input type=\"submit\" size=\"30\" name=\"loginBtn\" value=\"Submit\" id=\"subBtn\" class=\"button\"></td>\n");
      out.write("                                <td><a href=\"forgotPassword.jsp\" id=\"login\" class=\"forgotPwd\">Forgot your password?</a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        ");

                            if (request.getParameter("err") != null) {
                        
      out.write("\n");
      out.write("                        <center><font color=\"red\"><h2>Invalid Login Credentials</h2></font></center>\n");
      out.write("                            ");
                        }
                            
      out.write("   \n");
      out.write("                    </fieldset>\n");
      out.write("                </form>                    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

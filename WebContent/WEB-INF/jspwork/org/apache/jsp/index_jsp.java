/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.27
 * Generated at: 2018-03-19 01:52:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/Header.jsp", Long.valueOf(1521424329289L));
    _jspx_dependants.put("/Header1.jsp", Long.valueOf(1521419389536L));
    _jspx_dependants.put("/footer.html", Long.valueOf(1521006049911L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

//일반적인 자바소스코드가 작성되는 영역 
Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>first jsp</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/FWP/resources/css/newcss.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

if(loginUser !=null && loginUser.getUserid().equals("admin")){

      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>admin</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"/FWP/resources/css/newcss.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h1>첫 jsp</h1>\r\n");
      out.write("<nav>\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li><a href=\"/FWP/index.jsp\">home</a></li>\r\n");
      out.write("\t<li><a href=\"/FWP/mall\">회원관리</a></li>\r\n");
      out.write("\t<li><a href=\"/FWP/view\\notice\\noticeListView.jsp\">공지관리</a></li>\r\n");
      out.write("\t<li><a href=\"\">게시글관리</a></li>\r\n");
      out.write("\t<li><a href=\"\">앨범관리</a></li>\r\n");
      out.write("\t<li><a href=\"\">자료실</a></li>\r\n");
      out.write("\t<li><a href=\"\">자료실관리</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
 }else{
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>일반인</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"/FWP/resources/css/newcss.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h1>첫 jsp</h1>\r\n");
      out.write("<nav>\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li><a href=\"/FWP/index.jsp\">home</a></li>\r\n");
      out.write("\t<li><a href=\"\">회원</a></li>\r\n");
      out.write("\t<li><a href=\"/FWP/nlist\">공지사항</a></li>\r\n");
      out.write("\t<li><a href=\"\">게시글</a></li>\r\n");
      out.write("\t<li><a href=\"\">앨범</a></li>\r\n");
      out.write("\t<li><a href=\"\">자료</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<hr style=\"clear:both\">\r\n");
      out.write("<img src=\"images/11.jpg\" width=\"295\" height=\"171\" border=\"0\" alt=\"\" style=\"float:left;\">\r\n");
      out.write("\r\n");

if(loginUser==null) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form method=\"post\" action=\"login\"><!--서블릿의 매핑이름이 액션이름이다.  -->\r\n");
      out.write("<table width=\"220\" height=\"85\">\r\n");
      out.write("\t\t<tr height=\"25\">\r\n");
      out.write("\t\t<td width=\"170\"> \t\t<input type=\"text\" name=\"userid\"> \t\t</td> \r\n");
      out.write("\t\t<td rowspan=\"2\" >\t\t<input type=\"submit\" value=\"로그인\">\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"25\">\r\n");
      out.write("\t\t<td width=\"170\"> <input type=\"password\" name=\"password\"> </td><td></td></tr>\r\n");
      out.write("\t\t<tr height=\"25\">\r\n");
      out.write("\t\t<td width=\"170\"> <a href=\"/FWP/view/member/enroll.html\">회원가입</a>\r\n");
      out.write("\t\t</td><td>아디비번찾기</td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("</nav>\r\n");
}else{ 
      out.write("\r\n");
      out.write("<table width=\"220\" height=\"85\">\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\r\n");
      out.write("<td>");
      out.print( loginUser.getUserName() );
      out.write(" 새킈</td>\r\n");
      out.write("<td><a href=\"/FWP/logout\">로그아웃</a></td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr height=\"25\">\r\n");
      out.write("\r\n");
      out.write("<!--  쿼리 스트링, a 태그에서 사용함. 컨트롤러에게 전송할 값을 지정함. \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("href=\"대상이름 ?이름 이름=값\"\r\n");
      out.write("a태그는 전송방식이 get임.\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("-->\r\n");
      out.write("<td><a href=\"/FWP/MD?userid=");
      out.print(loginUser.getUserid());
      out.write("\">내정보보기</a></td>\r\n");
      out.write("<td>&nbsp;</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
} 
      out.write("\r\n");
      out.write("<hr style=\"clear:both\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("h5[align=center]{\r\n");
      out.write("background:navy;\r\n");
      out.write("color:white;\r\n");
      out.write("width:80%; \r\n");
      out.write("height:70px;\r\n");
      out.write("  position:absolute;\r\n");
      out.write("\r\n");
      out.write("    bottom:0;\r\n");
      out.write("\r\n");
      out.write("    width:100%;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer>\r\n");
      out.write("<h5 align=\"center\"> tmljf</h5>\r\n");
      out.write("copyright@2019.0.013 kh\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

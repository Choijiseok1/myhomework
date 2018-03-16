package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("로그인 서블릿 구동완료");
	//1.전송온 값이 한글이 ㅣㅇㅆ을경우 인코읻ㅇ
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("userid");
				String password=request.getParameter("password");
				
	//System.out.println("아이디:"+name+"\n비번:"+password);
    //3 비즈니스 로직을 담당할 서비스모델 클래스의 로그인 처리용 메소드로 값을 전달하고 ,결과를 받음	
	Member loginUser=new MemberService().loginCheck(name, password);
	
	//4. 받은 결과를 가지고 성공/실패에 따라 선택해서 내보냄
	response.setContentType("text/html; charset=utf-8");
	if(loginUser !=null ) {
		System.out.println("성공!~시의벌ㅋ");
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(60*30);//30분뒤 파기? 
		//System.out.println("세션 아이디"+session.getId());
		session.setAttribute("loginUser",loginUser);
		response.sendRedirect("/FWP/index.jsp");
		
	}else {
		
		response.sendRedirect("/FWP/view/member/loginFail.html");
		
		System.out.println("실패!~");
		
	}
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

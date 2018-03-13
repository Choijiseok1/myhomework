package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class Memberupdate
 */
@WebServlet("/MDUP")
public class Memberupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//회원 정보 수정 ㅋ처리용 컨트롤러
		//1 전송온 값에 한글이 있을경우 인코딩함.
		request.setCharacterEncoding("utf-8");
		//2 전송 온 값 꺼내서 변수 또는 객체에 저장.
		Member member = new Member();
		member.setUserid(request.getParameter("userid"));
		member.setUserPwd(request.getParameter("pw"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setEtc(request.getParameter("etc"));
		//취미.
		String[] hobbies=request.getParameterValues("hobby");
		List<String> hobbyList = new ArrayList<String>();
		
		for(String h : hobbies) {
		hobbyList.add(h);	
		}
		member.setHobby(String.join(",",hobbyList));
		//3 서비스 클래스에 메소드 전달과 결과받기
		int result= 0;
		result=new MemberService().updateMember(member);
		
		//4 받은 결과로 성공과 실패를 나누다.
		response.setContentType("text/html; charset=utf-8"); 
		
		if(result>0) {
			response.sendRedirect("/FWP/index.jsp");			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/member/memberError.jsp");
			request.setAttribute("message","수정실패.");
			view.forward(request,response);
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

package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/MDD")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		Member member=new Member();
		member.setUserid(request.getParameter("userid"));
		
		int result=0;
		result=new MemberService().deleteMember(member);

				
		response.setContentType("text/html; charset=utf-8");//내용물의 타입을 꼭 설정해주자.
		RequestDispatcher view=null;
				
		HttpSession session = request.getSession(false);
		if(result >0) {
			
			session.invalidate();
			
			response.sendRedirect("index.jsp");
							
			
			
			} else {
				view=request.getRequestDispatcher("view/member/memberError.jsp");
				request.setAttribute("message","정보보기 실패");
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

package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDetail
 */
@WebServlet("/MD")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 상세보기.
		String id=request.getParameter("userid");
		Member member=new MemberService().selectMember(id);
		
		response.setContentType("text/html; charset=utf-8");//내용물의 타입을 꼭 설정해주자.
			RequestDispatcher view=null;
			System.out.println(member);
			if(member != null) {
			view = request.getRequestDispatcher("view/member/memberdetail.jsp");
			request.setAttribute("member",member);
			view.forward(request,response);
			
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

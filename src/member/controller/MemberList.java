package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/mall")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자가 요청하는 회원 전체 조회처리용 컨트롤러.
		 ArrayList<Member> list=new MemberService().selecetList();
		 response.setContentType("text/html; charset=utf-8");
		 RequestDispatcher view= null;
		 if(list.size()>0) {
			 view=request.getRequestDispatcher("view/member/memberlist.jsp");
			 request.setAttribute("list",list);
			 view.forward(request, response);
		 }else {
			 view=request.getRequestDispatcher("view/member/memberError.jsp");
			 request.setAttribute("message","처리실패");
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

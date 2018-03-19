package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class Noticedel
 */
@WebServlet("/ndel")
public class Noticedel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Noticedel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//노티스에서는 노티스 번호를 받을것이므로 한글은없다.
		int noticeNo=new NoticeService().deleteNotice(Integer.parseInt(request.getParameter("no")));
		System.out.println("ggg");
		if(noticeNo>0) {
			response.sendRedirect("/FWP/nlist");
		}else {
			RequestDispatcher view=request.getRequestDispatcher("view\notice\noticeError.jsp");
			request.setAttribute("message","삭제 실패");
			view.forward(request, response);
			
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

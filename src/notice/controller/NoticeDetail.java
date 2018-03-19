package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetail
 */
@WebServlet("/ndetail")

public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeno=Integer.parseInt(request.getParameter("no"));
		
		Notice notice=new NoticeService().selectNotice(noticeno);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view=null;
		if(notice != null) {
		view = request.getRequestDispatcher("view/notice/noticeDetailView.jsp");
		request.setAttribute("notice", notice);
		view.forward(request, response);
		}else {
		view =request.getRequestDispatcher("view/notice/noticeError.jsp");
		request.setAttribute("message",noticeno+"번이 샐패함");
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

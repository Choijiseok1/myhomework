package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import notice.model.service.NoticeService;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/nlist")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지글 전체 목록 조회 컨트롤러
	List<notice.model.vo.Notice> nlist= new NoticeService().selectList();
	
	response.setContentType("text/html; charset=utf-8");
	
	RequestDispatcher view=null;
	System.out.println("공지수"+nlist.size());
	if(nlist.size()>0){
	view = request.getRequestDispatcher("view/notice/noticeListView.jsp");	
	request.setAttribute("nlist",nlist);
	view.forward(request,  response);
	}else{
	view=request.getRequestDispatcher("view/notice/noticeError.jsp");
	request.setAttribute("message","조회된 공지가 없음.");
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

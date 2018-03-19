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
 * Servlet implementation class MemberInsert
 */
@WebServlet("/minsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//회원가입처리용 컨트롤러
	//무엇을 해야할까????
	//1. 전송온 값에 한글이 있다면?? 인코딩처리해야겠지...?
	request.setCharacterEncoding("utf-8");
	
	//2. 전송 온 값을 꺼내서 변수에 또는 객체 안에 저장하자.
		Member member= new Member();
		member.setUserid(request.getParameter("id"));
		member.setUserPwd(request.getParameter("pw"));
		member.setUserName(request.getParameter("na"));
		member.setGender(request.getParameter("gender"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		//member.setHobby(request.getParameter("hobby")); 체크박스는 여러가지를 선택한다. 배열에 담는다.
		member.setEtc(request.getParameter("etc"));		
		
		//체크박스로 여러값을 받아왓을때 뽑아내는방법 1 기본적인방법.
		String[] hobbies= request.getParameterValues("hobby");
//		StringBuilder sb=new StringBuilder();
//		if(hobbies!=null) {
//			for(int i=0; i<hobbies.length; i++) {
//			    if(i<hobbies.length-1) {
//			    sb.append(hobbies[i]+",");	
//			    }
//			    else {
//			    sb.append(hobbies[i]);	
//			    }
//			}
//		member.setHobby(sb.toString());
//		
//		}
		
	//체크박스로 여러값을 받아왓을경우 뽑아내는방법2 어레이리스트의 조인을 이용하는방법.
		List<String> list= new ArrayList<String>(); 
		if(hobbies != null) {
			for(String s : hobbies) {
				list.add(s);
			}
		}
	member.setHobby(String.join(",",list));
	System.out.println(member);
	

	//3. 비즈니스 로직을 처리하는 서비스로 객체 또는 값을 전달하고 결과받아서 뷰에 응답쳐리. 
	
	int result = new MemberService().insertMember(member);
	response.setContentType("text/html; charset=utf-8"); 
	
	if(result==0) {
		
	
		//뷰파일을 설정할땐 절대경로가 불가능 무조건 상대경로로 해야한다
		
		RequestDispatcher view=
		request.getRequestDispatcher("view/member/memberError.jsp");
		request.setAttribute("message","회원가입실패");
		view.forward(request,response);
		
	}else {
		
		response.sendRedirect("index.jsp");
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

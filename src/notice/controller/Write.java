package notice.controller;
import notice.model.service.NoticeService;
import notice.model.vo.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Write
 */
@WebServlet("/nwrite")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일업로드 기능이 추가된 공지글 등록 처리용 컨트롤러
				//1. 전송온 값에 한글이 있을 경우 인코딩처리함
				request.setCharacterEncoding("utf-8");
				
				//업로드할 파일의 용량 제한 : 10Mbyte 로 제한한다면
				int maxSize = 1024 * 1024 * 10;
				
				//enctype="multipart/form-data" 로 전송됐는지 확인
				RequestDispatcher view = null;
				if(!ServletFileUpload.isMultipartContent(request)) {
					//enctype 설정이 되지 않았다면
					view = request.getRequestDispatcher("views/notice/noticeError.jsp");
					request.setAttribute("message", "form 태그에 enctype 속성이 설정되지 않았습니다.");
					view.forward(request, response);
				}
				
				//해당 웹 컨테이너(was:톰켓)에서 구동중인 웹 애플리케이션의
				//루트 경로(content directory) 알아냄
				String root = request.getSession().getServletContext().getRealPath("/");
				//System.out.println("root : " + root);
				//업로드되는 파일이 저장될 폴더명과 루트 경로 연결
				String savePath = root + "notice_upload";
				//System.out.println("savePath : " + savePath);
				//web/notice_upload 로 출력됨
				
				//cos.jar 라이브러리를 사용할 경우, MultipartRequest 객체 생성
				//객체 생성과 동시에 자동 파일 업로드됨
				//request 객체는 MultipartRequest 객체로 변환됨
				MultipartRequest mrequest = new MultipartRequest(
						request, savePath, maxSize, "utf-8",
						new DefaultFileRenamePolicy()
						);		
				
			
				//2. 전송온 값 꺼내서 변수 또는 객체에 저장하기
				/*Notice notice = new Notice();
				notice.setNoticeTitle(request.getParameter("title"));
				notice.setNoticeWriter(request.getParameter("writer"));
				notice.setNoticeContent(request.getParameter("content")); */
				
				notice.model.vo.Notice notice = new notice.model.vo.Notice();
				notice.setNoticeTitle(mrequest.getParameter("title"));
				notice.setNoticeWriter(mrequest.getParameter("writer"));
				notice.setNoticeContent(mrequest.getParameter("content"));
				notice.setOriginalFilePath(mrequest.getFilesystemName("upfile"));
				//notice.setRenameFilePath(mrequest.getFilesystemName("upfile"));
					
				//만약 클라이언트간 파일명이 같은 경우에는?
				//저장폴더에 기록되는 파일명을 '년월일시분초.확장자' 형식으로 이름을 바꿔서 기록저장.
				String originfileName=notice.getOriginalFilePath();
				if(originfileName!=null) {
					//첨부된 파일이 있을경우 폴더에 기록된 해당 파일의 이름 바꾸기 처리함.
					//새로운 파일명 만들기. "년월일시분초"

					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
					String renameFileName = 
					sdf.format(new java.sql.Date(System.currentTimeMillis()))+"."+originfileName.substring(originfileName.lastIndexOf(".")+1);
					System.out.println(renameFileName);
					//파일 명을 바꾸려먼 file 객체의 renameTo() 사용함
					File originFile= new File(savePath+"\\"+originfileName);
					File renamefile=new File(savePath+"\\"+renameFileName);
					//파일 이름 바꾸기 실행.
					
					//이름 바꾸기 실패의 경우에는 직접바꾸기 해야함.
				
					//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본을 삭제한다.
					if(!originFile.renameTo(renamefile)) {
						//파일이름을 바꾸는것에 실패를 햇다.
						int read=-1;
						byte[] buf=new byte[1024];
						//한번에 읽을 배열 크기 지정.
						//원본을 읽기 위한 파일스트림 생성.
						FileInputStream fin=new FileInputStream(originFile);
						//읽은 내용 기록할 복사본 파일 출력용 파일스트림생성.
						FileOutputStream fout =new FileOutputStream(renamefile);
						//원본 읽어서 복사본에 기록처리
						while((read=fin.read(buf,0,buf.length))!=-1){
							fout.write(buf,0,read);
						}
						fin.close();
						fout.close();
						originFile.delete();
						
					}//rename if
					
					notice.setRenameFilePath(renameFileName);					
					
				}
				
				
				//3. 서비스 클래스 메소드로 값 전달하고, 결과 받기
				int result = new NoticeService().insertNotice(notice);
				
				//4. 받은 결과를 가지고 성공/실패에 대한 뷰를 선택해서 내보냄
				response.setContentType("text/html; charset=utf-8");
				if(result > 0) {
					response.sendRedirect("/FWP/nlist");
				}else {
					view = request.getRequestDispatcher("view/notice/noticeError.jsp");
					request.setAttribute("message", "게시글 등록 실패!");
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

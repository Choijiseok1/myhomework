package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 공지글 수정 처리용 컨트롤러
				// 1. 전송온 값에 한글이 있을 경우 인코딩처리함
				request.setCharacterEncoding("utf-8");

				// 업로드할 파일의 용량 제한 : 10Mbyte 로 제한한다면
				int maxSize = 1024 * 1024 * 10;

				// enctype="multipart/form-data" 로 전송됐는지 확인
				RequestDispatcher view = null;
				if (!ServletFileUpload.isMultipartContent(request)) {
					// enctype 설정이 되지 않았다면
					view = request.getRequestDispatcher("view/notice/noticeError.jsp");
					request.setAttribute("message", "form 태그에 enctype 속성이 설정되지 않았습니다.");
					view.forward(request, response);
				}

				// 해당 웹 컨테이너(was:톰켓)에서 구동중인 웹 애플리케이션의
				// 루트 경로(content directory) 알아냄
				String root = request.getSession().getServletContext().getRealPath("/");
				// System.out.println("root : " + root);
				// 업로드되는 파일이 저장될 폴더명과 루트 경로 연결
				String savePath = root + "notice_upload";
				// System.out.println("savePath : " + savePath);
				// web/notice_upload 로 출력됨

				// cos.jar 라이브러리를 사용할 경우, MultipartRequest 객체 생성
				// 객체 생성과 동시에 자동 파일 업로드됨
				// request 객체는 MultipartRequest 객체로 변환됨
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8",
						new DefaultFileRenamePolicy());

				// 2. 전송온 값 꺼내서 변수 또는 객체에 저장하기
				Notice notice = new Notice();
				notice.setNoticeNO(Integer.parseInt(mrequest.getParameter("no")));
				notice.setNoticeTitle(mrequest.getParameter("title"));
				notice.setNoticeWriter(mrequest.getParameter("writer"));
				notice.setNoticeContent(mrequest.getParameter("content"));
				
				String upfile = mrequest.getParameter("upfile");
				
				System.out.println("upfile="+upfile);
				//첨부파일이 변경되었다면
				if(upfile != null) {
				
					notice.setOriginalFilePath(upfile);
					System.out.println(notice.getOriginalFilePath());
					// 만약, 클라이언트간 파일명이 같을 경우 오바라이트되지 않게 하려면
					// 저장폴더에 기록되는 파일명을 '년월일시분초.확장자' 형식으로
					// 이름을 바꾸어 기록 저장되게 처리함
					String originFileName = notice.getOriginalFilePath();
					if (originFileName != null) {
						// 첨부된 파일이 있을 경우, 폴더에 기록된 해당 파일의
						// 이름 바꾸기 처리함
						// 새로운 파일명 만들기 : "년월일시분초.확장자"
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
						String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
								+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
			
						// 파일명 바꾸려면 File 객체의 renameTo() 사용함
						File originFile = new File(savePath + "\\" + originFileName);
						File renameFile = new File(savePath + "\\" + renameFileName);
			
						// 파일 이름바꾸기 실행함
						// 이름바꾸기 실패할 경우에는 직접 바꾸기함
						// 직접바꾸기는 원본파일에 대한 복사본 파일을 만든 다음
						// 원본 삭제함
						if (!originFile.renameTo(renameFile)) {
							// 파일이름바꾸기 실패했다면
							int read = -1;
							byte[] buf = new byte[1024];
							// 한번에 읽을 배열 크기 지정
			
							// 원본을 읽기 위한 파일스트림 생성
							FileInputStream fin = new FileInputStream(originFile);
							// 읽은 내용 기록할 복사본 파일 출력용 파일스트림 생성
							FileOutputStream fout = new FileOutputStream(renameFile);
			
							// 원본 읽어서 복사본에 기록 처리
							while ((read = fin.read(buf, 0, buf.length)) != -1) {
								fout.write(buf, 0, read);
							}
			
							// 스트림 반납
							fin.close();
							fout.close();
							originFile.delete(); // 원본 파일 삭제함
						} // renameTo if close
			
						notice.setRenameFilePath(renameFileName);
					}
				} // upfile != null : 첨부파일이 변경되었을 때
				
				// 3. 서비스 클래스 메소드로 값 전달하고, 결과 받기
				System.out.println(notice);
				int result = new NoticeService().updateNotice(notice);

				// 4. 받은 결과를 가지고 성공/실패에 대한 뷰를 선택해서 내보냄
				response.setContentType("text/html; charset=utf-8");
				if (result > 0) {
					//수정 성공시 상세보기 페이지로 넘김
					response.sendRedirect("/FWP/ndetail?no=" + notice.getNoticeNO());
				} else {
					view = request.getRequestDispatcher("view/notice/noticeError.jsp");
					request.setAttribute("message", 
							notice.getNoticeNO() + "번 게시글 수정 실패!");
					view.forward(request, response);
				}
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

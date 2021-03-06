package notice.model.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.sun.corba.se.spi.orbutil.fsm.State;

import static common.jdbcTemplate.*;
import notice.model.vo.Notice;


	 public class NoticeDao {
			public NoticeDao() {}
			
			public List<Notice> selectList(Connection con){
				List<Notice> list = new ArrayList<Notice>();
				Statement stmt = null;
				ResultSet rset = null;
				
				String query = "select * from notice order by noticeno desc";
				
				try {
					stmt = con.createStatement();
					rset = stmt.executeQuery(query);
					
					while(rset.next()) {
						Notice n = new Notice();
						
						n.setNoticeNO(rset.getInt("noticeno"));
						n.setNoticeTitle(rset.getString("noticetitle"));
						n.setNoticeDate(rset.getDate("noticedate"));
						n.setNoticeWriter(rset.getString("noticewriter"));
						n.setNoticeContent(rset.getString("noticecontent"));
						n.setOriginalFilePath(rset.getString("original_filepath"));
						n.setRenameFilePath(rset.getString("rename_filepath"));
						
						list.add(n);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(stmt);
				}
				
				return list;
			}
			
			public Notice selectNotice(Connection con, int noticeNo) {
				Notice notice = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String query = "select * from notice where noticeno = ?";
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, noticeNo);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						notice = new Notice();
						
						notice.setNoticeNO(noticeNo);
						notice.setNoticeTitle(rset.getString("noticetitle"));
						notice.setNoticeWriter(rset.getString("noticewriter"));
						notice.setNoticeContent(rset.getString("noticecontent"));
						notice.setNoticeDate(rset.getDate("noticedate"));
						notice.setOriginalFilePath(rset.getString("original_filepath"));
						notice.setRenameFilePath(rset.getString("rename_filepath"));				
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
				return notice;
			}
			
			public int insertNotice(Connection con, Notice notice) {
				int result = 0;
				PreparedStatement pstmt = null;
				
				String query = "insert into notice values ("
						+ "(select max(noticeno) from notice) + 1, "
						+ "?, default, ?, ?, ?, ?)";
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, notice.getNoticeTitle());
					pstmt.setString(2, notice.getNoticeWriter());
					pstmt.setString(3, notice.getNoticeContent());
					pstmt.setString(4, notice.getOriginalFilePath());
					pstmt.setString(5, notice.getRenameFilePath());
					
					result = pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				return result;
			}
			
			public int updateNotice(Connection con, Notice notice) {
				int result = 0;
				PreparedStatement pstmt =null;
				String query=null;
				if(notice.getOriginalFilePath()!=null) {
			query="update notice set NOTICETITLE=? , NOTICECONTENT=?, ORIGINAL_FILEPATH=?, RENAME_FILEPATH=? where NOTICENO=?";
					}else {
			query="update notice set NOTICETITLE=? , NOTICECONTENT=? where NOTICENO=?";					
				}
				try {
					pstmt=con.prepareStatement(query);
					pstmt.setString(1, notice.getNoticeTitle());
					pstmt.setString(2, notice.getNoticeContent());
					if(notice.getOriginalFilePath()!=null) {
					pstmt.setString(3, notice.getOriginalFilePath());
					pstmt.setString(4,notice.getRenameFilePath());
					pstmt.setInt(5,notice.getNoticeNO());
					
					}
					pstmt.setInt(3,notice.getNoticeNO());
				result=pstmt.executeUpdate();
					
				} catch (Exception e) {
				e.printStackTrace();
				}finally {
					close(pstmt);
				}
					
				return result;
			}
			
			public int deleteNotice(Connection con, int noticeNo) {
				int result = 0;
				PreparedStatement pstmt=null;
				System.out.println("noticeNo="+noticeNo);
				String query="delete from notice where noticeno = ?";
				try {
					pstmt=con.prepareStatement(query);
					pstmt.setInt(1,noticeNo);
					result=pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				return result;
			}
			
			public List<Notice> selectSearchTitle(Connection con, 
					String keyword){
				List<Notice> list = new ArrayList<Notice>();
				
				return list;
			}
			
			public List<Notice> selectSearchDate(Connection con,
					Date start, Date end){
				List<Notice> list = new ArrayList<Notice>();
				
				return list;
			}
			
			public List<Notice> selectSearchWriter(Connection con,
					String keyword){
				List<Notice> list = new ArrayList<Notice>();
				
				return list;
			}
		}


package notice.model.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.sun.corba.se.spi.orbutil.fsm.State;

import static common.jdbcTemplate.*;
import notice.model.vo.Notice;

public class NoticeDao {
 public NoticeDao() {
	// TODO Auto-generated constructor stub
}

	
	public List<Notice> selectList(Connection con){
		List<Notice> list=new ArrayList<Notice>();
		Statement stmt=null;
		ResultSet rset=null;
		String query="select * from notice order by noticeno desc";
		try {
			stmt=con.createStatement();
			rset=stmt.executeQuery(query);
			
			while(rset.next()) {
				
				Notice n = new Notice();
				n.setNoticeNO(rset.getInt("NOTICENO"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setNoticeDate(rset.getDate("NOTICEDATE"));
				n.setNoticeWriter(rset.getString("NOTICEWRITER"));
				n.setNoticeContent(rset.getString("NOTICECONTENT"));
				n.setOriginalFilePath(rset.getString("ORIGINAL_FILEPATH"));
				n.setRenameFilePath(rset.getString("RENAME_FILEPATH"));
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
		return null;
		}
	
	public int insertNotice(Connection con, Notice notice) {		
		return (Integer) null;
		}
	
	public int updateNotice(Connection con, Notice notice) {		
		return (Integer) null;
		}
	
	public int deleteNotice(Connection con, int noticeNo) {	
		int result = 0;
		
		
		
		return (Integer) null;
		}
	
	public List<Notice> selectSearchTitle(Connection con, 
			String keyword){		
		return null;
		}
	
	public List<Notice> selectSearchDate(Connection con,
			Date start, Date end){	
		List<Notice> list=new ArrayList<Notice>();
	
		
		return null;
		}
	
	public List<Notice> selectSearchWriter(Connection con,
			String keyword){		
		return null;
		}

}

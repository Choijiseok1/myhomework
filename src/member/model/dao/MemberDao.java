package member.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sun.imageio.stream.StreamCloser.CloseAction;
import com.sun.xml.internal.ws.Closeable;

import member.model.vo.Member;

import static common.jdbcTemplate.*;

public class MemberDao {


	public MemberDao() {}
	public Member loginMember(Connection con, String id, String pw) {

		
	Member loginUser=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String query="select * from member where userid= ? and userpwd=?";
	    if(con!=null) 
	    	{
	    	try 
	    	{
			pstmt=con.prepareStatement(query);
	    	pstmt.setString(1,id);
	    	pstmt.setString(2,pw);
	    	rset=pstmt.executeQuery();
	    	if(rset.next()) {
	       loginUser=new Member();
	       loginUser.setUserid(rset.getString("userid"));
	       loginUser.setUserPwd(rset.getString("UserPwd"));
	       loginUser.setUserName(rset.getString("username"));
	       loginUser.setGender(rset.getString("gender"));
	       loginUser.setAge(rset.getInt("age"));
	       loginUser.setPhone(rset.getString("Phone"));
	       loginUser.setEmail(rset.getString("email"));
	       loginUser.setHobby(rset.getString("hobby"));
	       loginUser.setEtc(rset.getString("etc"));
	       loginUser.setEnrollDate(rset.getDate("enrollDate"));
	       loginUser.setLastModified(rset.getDate("lastModified"));
	   
	    	}
	    	System.out.println("dao"+loginUser);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				close(con);
				close(pstmt);
			}
	    	
	    	
	    	
	    	
	    	}
	
	return loginUser; 
	}
	
	
	public int insertMember(Connection con, Member member) {
		int result=0;
		PreparedStatement pstmt=null;
		String query="insert into member values(?,?,?,?,?,?,?,?,?,sysdate,default)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,member.getUserid());
			pstmt.setString(2,member.getUserPwd());
			pstmt.setString(3,member.getUserName());
			pstmt.setString(4,member.getGender());
			pstmt.setInt(5,member.getAge());
			pstmt.setString(6,member.getPhone());
			pstmt.setString(7,member.getEmail());
			pstmt.setString(8,member.getHobby());
			pstmt.setString(9,member.getEtc());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int updateMember(Connection con, Member member) {
	int result=0;
		PreparedStatement pstmt=null;
		String query="update member set userpwd=? , age=? , phone=? , email=? , hobby=? , etc=? , lastmodified=sysdate where userid=?  ";
		System.out.println(member);
		try {
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,member.getUserPwd());
		pstmt.setInt(2,member.getAge());
		pstmt.setString(3,member.getPhone());
		pstmt.setString(4,member.getEmail());
		pstmt.setString(5,member.getHobby());
		pstmt.setString(6,member.getEtc());
		pstmt.setString(7,member.getUserid());	
		result=pstmt.executeUpdate();
		System.out.println("이걸로감");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteMember(Connection con, Member member) {
		int result=0;
		PreparedStatement pstmt=null;
		String query="delete from member where userid = ?";
		
		System.out.println(member.getUserid());
		try {
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,member.getUserid());
		result=pstmt.executeUpdate();
		
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	
	
	
	public Member selectMember(Connection con, String id) {
		Member member=null;
		PreparedStatement pstmt=null;
		ResultSet rest=null;

		String query="select * from member where USERID= ? ";
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1,id);
			rest=pstmt.executeQuery();
			
			if(rest.next()) {
				member=new Member();
				member.setUserid(id);
				member.setUserPwd(rest.getString("userpwd"));
				member.setUserName(rest.getString("username"));
				member.setGender(rest.getString("gender"));
				member.setAge(rest.getInt("age"));
				member.setPhone(rest.getString("phone"));
				member.setEmail(rest.getString("email"));
				member.setHobby(rest.getString("hobby"));
				member.setEtc(rest.getString("etc"));				
				member.setEnrollDate(rest.getDate("enroll_date"));
				member.setLastModified(rest.getDate("lastmodified"));
		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rest);
			close(pstmt);
		}
		
		return member;
	}
	public ArrayList<Member> selectList(Connection con) {
		ArrayList<Member> list=new ArrayList<Member>();
		
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		String query="select * from member";
		try {
			pstmt=con.prepareStatement(query);
			rest=pstmt.executeQuery();
			while(rest.next()) {
			    Member member=new Member();
				member.setUserid(rest.getString("userid"));
				member.setUserPwd(rest.getString("userpwd"));
				member.setUserName(rest.getString("username"));
				member.setGender(rest.getString("gender"));
				member.setAge(rest.getInt("age"));
				member.setPhone(rest.getString("phone"));
				member.setEmail(rest.getString("email"));
				member.setHobby(rest.getString("hobby"));
				member.setEtc(rest.getString("etc"));				
				member.setEnrollDate(rest.getDate("enroll_date"));
				member.setLastModified(rest.getDate("lastmodified"));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		return list;
	}
	
}

package member.model.service;

// 불러오기에도 스태틱이 붙는다.
import static common.jdbcTemplate.*;

import java.sql.*;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;


//서비스에서는 커낵션 준비.

public class MemberService {
	MemberDao dao=new MemberDao();
	public MemberService() {}
	
	public Member loginCheck(String userId, String userPwd) {
	
	Connection conn = getConnection(); 

	Member logind=dao.loginMember(conn,userId,userPwd);
	
	return logind;
	}
	public int insertMember(Member member) {
		Connection con=getConnection();
		
		int result= new MemberDao().insertMember(con,member);
		
		if(result>0)commit(con);
		else rollback(con);
		close(con);
		
		return result;
	}
	
	
	
	
	
	public int updateMember(Member member) {
		Connection con=getConnection();
		
		int result= new MemberDao().updateMember(con,member);
		
		if(result>0)
			commit(con);
		
		else 
			rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	
	public int deleteMember(Member member) {
		Connection con=getConnection();
		int result=new MemberDao().deleteMember(con,member);
		if(result>0)
			commit(con);
		else 
			rollback(con);
		
		close(con);
		return result;
	}

	public Member selectMember(String id) {
    Connection con= getConnection();
    Member member= new MemberDao().selectMember(con,id);
	close(con);
	return member;
	}

	public ArrayList<Member> selecetList() {
	Connection con=getConnection();
	ArrayList<Member> list=new MemberDao().selectList(con);
	close(con);
	
	return list;
	}

	
}

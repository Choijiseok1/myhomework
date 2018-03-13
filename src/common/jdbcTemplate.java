package common;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.*;
//jdbc 클래스는 전부 클래스로 할것이다.

public class jdbcTemplate {

	public static Connection getConnection() {
		Connection con= null;
	
		Properties prop=new Properties();
		try {
		
//			prop.load(new FileReader("./driver.properties"));
//			
//			String driver=prop.getProperty("driver");
//			String url=prop.getProperty("url");
//			String user = prop.getProperty("user");
//			String pwd=prop.getProperty("pwd");
			
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user ="mmmm";
			String pwd="1234";

			
			
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,user,pwd);
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public static void commit(Connection con) {
		try {
			if( con != null && !con.isClosed() )
				con.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void rollback(Connection con) {
		try {
			if( con != null && !con.isClosed() )
				con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if( stmt != null && !stmt.isClosed() )
				stmt.close();
			} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void close(ResultSet rset) {
		try {
			if( rset != null && !rset.isClosed() )
				rset.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
	public static void close(Connection con) {
		try {
			if( con != null && !con.isClosed() )
				con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

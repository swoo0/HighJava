package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	// static 블럭은 JDBCUtil이 불러 질때 최초 한번만 실행된다.
	
	// oracle 과 연결이 됬는지 확인.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KSW90", "java");
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	/*
		자원 반납
	*/
	public static void disConnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try {conn.close();} catch (SQLException ex) {}
		if (stmt != null) try {stmt.close();} catch (SQLException ex) {}
		if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		if (rs != null) try {rs.close();} catch (SQLException ex) {}

	}
	
	
}

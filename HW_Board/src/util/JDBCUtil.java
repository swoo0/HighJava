package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {

	static ResourceBundle bundle; // 객체 생성
	
	static {
		
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
//			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() {
		
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}

	/*
		자원 반납
	*/
	public static void disConnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try {conn.close();} catch (SQLException ex) {};
		if (stmt != null) try {stmt.close();} catch (SQLException ex) {};
		if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {};
		if (rs != null) try {rs.close();} catch (SQLException ex) {};
	}
}


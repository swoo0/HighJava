package kr.or.ddit.member.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
	db.properties파일의 내용으로 DB정보를 설정하는 방법
	방법1) Properties객체 이용하기
	
*/
public class JDBCUtil2 {
	
	static Properties prop; // Properties객체변수 선언
	
	// static 블럭은 JDBCUtil이 불러 질때 최초 한번만 실행된다.
	
	// oracle 과 연결이 됬는지 확인.
	static {
		
		prop = new Properties(); // 객체 생성
		
		try {
			
			FileInputStream fis = new FileInputStream("res/db.properties");			
			
			prop.load(fis);
			
			fis.close();
			
			
			Class.forName(prop.getProperty("driver"));
			System.out.println("드라이버 로딩 완료!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
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

package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVO;
import util.JDBCUtil;

public class BoardDaoImpl implements IBoardDao {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "select * from JDBC_BOARD";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String boardNo = rs.getString("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardWriter = rs.getString("BOARD_WRITER");
				String boardDate = rs.getString("BOARD_DATE");
				String boardContent = rs.getString("BOARD_CONTENT");
				
				BoardVO bv = new BoardVO();
				bv.setBoardNo(boardNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardWriter(boardWriter);
				bv.setBoardDate(boardDate);
				bv.setBoardContent(boardContent);
				
				boardList.add(bv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return boardList;
	}

	@Override
	public int writeBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "insert into JDBC_BOARD "
					+ " (board_no, board_title, board_writer, board_date, board_content) "
					+ " values (BOARD_SEQ.nextVal, ?, ?, sysdate, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardContent());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "update jdbc_board "
					+ " set board_title = ?, "
					+ "		board_writer = ?, "
					+ "		board_content = ? "
					+ "	where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardContent());
			pstmt.setString(4, bv.getBoardNo());

			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(String boardNo) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "delete from jdbc_board "
					+ "where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNo) {
		
		boolean isExist = false;
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "select count(*) as cnt from JDBC_BOARD "
					+ "		where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
	
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if (cnt > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return isExist;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "select * from JDBC_BOARD where 1=1 ";
			
			if (bv.getBoardNo() != null && !bv.getBoardNo().equals("")) {
				sql += " and board_no = ? ";
			}
			if (bv.getBoardTitle() != null && !bv.getBoardTitle().equals("")) {
				sql += " and board_title = ? ";
			}
			if (bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				sql += " and board_writer = ? ";
			}
//			if (bv.getBoardDate() != null && !bv.getBoardDate().equals("")) {
//				sql += " and board_date = ? ";
//			}
//			if (bv.getBoardContent() != null && !bv.getBoardContent().equals("")) {
//				sql += " and board_content like '%' || ? || '%' ";
//			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if (bv.getBoardNo() != null && !bv.getBoardNo().equals("")) {
				pstmt.setString(index++, bv.getBoardNo());
			}
			if (bv.getBoardTitle() != null && !bv.getBoardTitle().equals("")) {
				pstmt.setString(index++, bv.getBoardTitle());
			}
			if (bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				pstmt.setString(index++, bv.getBoardWriter());
			}
//			if (bv.getBoardDate() != null && !bv.getBoardDate().equals("")) {
//				pstmt.setString(index++, bv.getBoardDate());
//			}
//			if (bv.getBoardContent() != null && !bv.getBoardContent().equals("")) {
//				pstmt.setString(index++, bv.getBoardContent());
//			}
//			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String boardNo = rs.getString("board_no");
				String boardTitle = rs.getString("board_title");
				String boardWriter = rs.getString("board_writer");
				String boardDate = rs.getString("board_date");
				String boardContent = rs.getString("board_content");
				
				BoardVO bv2 = new BoardVO();
				bv2.setBoardNo(boardNo);
				bv2.setBoardTitle(boardTitle);
				bv2.setBoardWriter(boardWriter);
				bv2.setBoardDate(boardDate);
				bv2.setBoardContent(boardContent);
				
				boardList.add(bv2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return boardList;
	}

	
}

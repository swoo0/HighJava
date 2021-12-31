package board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;
import util.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	
	// 싱글톤
	private static IBoardDao boardDao;
	
	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	
	// 사용할 iBatis 객체 변수 선언
	private SqlMapClient smc;
	
	private BoardDaoImpl () {
		smc = SqlMapClientFactory.getInstance();
	}
	
	
	
	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("board.getBoardAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public int writeBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("board.writeBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("board.updateBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(String boardNo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deleteBoard", boardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNo) {
		
		boolean isExist = false;
		
		try {
			int cnt = (int) smc.queryForObject("board.checkBoard", boardNo);
			
			if (cnt > 0) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isExist;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("board.searchBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	
}

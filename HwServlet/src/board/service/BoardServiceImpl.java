package board.service;

import java.util.List;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService boardService;
	
	public static IBoardService getInstance() {
		if (boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	// 사용할 Dao의 객체변수 선언.
	private IBoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	
	
	@Override
	public List<BoardVO> getAllBoardList() {
		return boardDao.getAllBoardList();
	}


	@Override
	public BoardVO getBoard(String boardNo) {
		return boardDao.getBoard(boardNo);
	}
	
	@Override
	public int writeBoard(BoardVO bv) {
		return boardDao.writeBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}
	
	@Override
	public boolean checkBoard(String boardNo) {
		return boardDao.checkBoard(boardNo);
	}
	
	@Override
	public int deleteBoard(String boardNo) {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		return boardDao.searchBoard(bv);
	}





}

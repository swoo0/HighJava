package board.dao;

import java.util.List;

import board.vo.BoardVO;

// DB와 연결해서 SQL문을 수행한 결과를 받아 
// Service에 전달하는 DAO 인터페이스.

public interface IBoardDao {

	/**
	 * DB안의 JDBC_BOARD 테이블의 전체 레코들르 가져와서
	 * List에 담아 반환하는 메서드
	 * @return B
	 */
	public List<BoardVO> getAllBoardList(); 
	
	
	/**
	 * BoradVO에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param bv DB에 write할 자료가 저장된 BoradVO 객체
	 * @return 작업성공 : 1 이상, 작업실패 : 0
	 */
	public int writeBoard(BoardVO bv);
	
	
	/**
	 * 하나의 BoardVO 자료를 이용하여 DB를 update하는 메서드
	 * @param bv update할 게시판 정보가 담긴 BoardVO 객체
	 * @return 작업성공 : 1 이상, 작업실패 : 0
	 */
	public int updateBoard(BoardVO bv);
	
	
	/**
	 * 주어진 게시글번호가 존재하는지 여부를 알아내기 위한 메서드
	 * @param boardNo 검색할 게시글 번호
	 * @return 해당 게시글 번호가 있으면 true, 없으면 false를 리턴함.
	 */
	public boolean checkBoard(String boardNo);
	
	
	/**
	 * 게시판 NO를 매개변수로 받아서 해당 회원정보를 삭제하는 메서드 
	 * @param boardNo 삭제한 게시판 NO
	 * @return
	 */
	public int deleteBoard(String boardNo);
	
	
	/**
	 * BoardVO에 담긴 자료를 이용하여 게시판을 검색하는 메서드
	 * @param mv 검색할 자료가 들어있는 BoardVO객체
	 * @return 검색된 결과를 담은 List객체
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	
	
	
	
	
}
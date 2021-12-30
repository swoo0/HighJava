package board.main;

import java.util.List;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import util.Scan;

public class BoardMain {
	

	// 사용할 Service 객체를 담을 변수 선언.
	private IBoardService boardService;

	private BoardMain() {
		boardService = BoardServiceImpl.getInstance(); 
	}
	
	
	public static void main(String[] args) {
		new BoardMain().start();
	}

	// 메뉴 출력 메서드.
	public void displayMenu() {
		System.out.println("---------------------");
		System.out.println(" === 게시판 메뉴 === ");
		System.out.println(" 1. 게시글 등록 ");
		System.out.println(" 2. 게시글 수정 ");
		System.out.println(" 3. 게시글 삭제 ");
		System.out.println(" 4. 게시글 검색 ");
		System.out.println(" 5. 게시글 전체 조회");
		System.out.println(" 6. 종료 ");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 >> ");
	}

	// 시작 메서드
	public void start() {

		int select;

		while (true) {
			displayMenu();
			select = Scan.nextInt();

			switch (select) {
			case 1: // 게시글 등록
				writeBoard();
				break;
			case 2: // 게시글 수정
				updateBoard();
				break;
			case 3: // 게시글 삭제
				deleteBoard();
				break;
			case 4: // 게시글 검색
				searchBoard();
				break;
			case 5: // 게시글 검색
				// 게시글 전체 조회
				dispalyBoardAll();
				break;
			case 6:
				System.out.println("게시판 작업을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	/*
	 * 게시판에 글을 추가하기 위한 메서드
	 */
	private void writeBoard() {

		System.out.println("===== 게시글 등록 =====");
		System.out.print("제목을 입력해주세요 >> ");
		String boardTitle = Scan.nextLine();
		System.out.print("작성자명을 입력해주세요 >> ");
		String boardWriter = Scan.nextLine();
		System.out.println("내용을 입력해주세요 >> ");
		String boardContent = Scan.nextLine();

		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);

		int result = boardService.writeBoard(bv);

		
		
		if (result > 0) {
			System.out.println("게시글 작성 완료.");
		} else {
			System.out.println("게시글 작성 실패 !!");
		}
	}

	private void dispalyBoardAll() {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println(" NO\t제 목\t작성자명\t작성일자\t내 용");
		System.out.println("----------------------------------------------------------");
		
		List<BoardVO> boardList = boardService.getAllBoardList();
		
		if (boardList.size() == 0) {
			System.out.println("조회할 게시글이 없습니다.");
		} else {
			for (BoardVO bv : boardList) {
				System.out.println(" " + bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t" + bv.getBoardWriter() +  "\t" + bv.getBoardDate() +  "\t" + bv.getBoardContent());
				
			}
			System.out.println("----------------------------------------------------------");
		}
	}
	
	/*
	 * 게시글을 수정하기 위한 메서드
	 */
	private void updateBoard() {

		boolean chk = false;

		System.out.println("===== 게시글 수정 =====");
		System.out.print("수정할 게시글 번호를 입력해주세요 >> ");
		String boardNo = Scan.nextLine();

		chk = checkBoard(boardNo);

		if (chk == false) {
			System.out.println("해당 번호의 게시글이 존재 하지 않습니다.");
			return;
			
		} else {
			System.out.print("제목을 입력해주세요 >> ");
			String boardTitle = Scan.nextLine();
			System.out.print("작성자명을 입력해주세요 >> ");
			String boardWriter = Scan.nextLine();
			System.out.println("내용을 입력해주세요 >> ");
			String boardContent = Scan.nextLine();
			
			BoardVO bv = new BoardVO();
			bv.setBoardTitle(boardTitle);
			bv.setBoardWriter(boardWriter);
			bv.setBoardContent(boardContent);
			bv.setBoardNo(boardNo);
			
			int result = boardService.updateBoard(bv);
			
			if (result > 0) {
				System.out.println("게시글 수정 완료");
			} else {
				System.out.println("게시글 수정 실패 !");
			}
		}
	}
	
	/*
	 * 게시글을 삭제하기 위한 메서드
	 */
	private void deleteBoard() {
		
		boolean chk = false;
		
		System.out.println("===== 게시글 삭제 =====");
		System.out.print("삭제할 게시글 번호를 입력해주세요 >> ");
		String boardNo = Scan.nextLine();
		
		chk = checkBoard(boardNo);
		
		if (chk == false) {
			System.out.println("해당 번호의 게시글이 존재 하지 않습니다.");
			return;
		} else {
			
			int cnt = boardService.deleteBoard(boardNo);
			
			if (cnt > 0) {
				System.out.println(boardNo + " 번 게시글 삭제 완료");
			} else {
				System.out.println(boardNo + " 번 게시글 삭제 실패 !");
			}
		}
	}
	
	/*
	 * 게시글을 검색하기 위한 메서드
	 */
	private void searchBoard() {
		
		System.out.println();
		System.out.println("검색할 게시글 정보를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		String boardNo = Scan.nextLine().trim();
		System.out.print("제목 >> ");
		String boardTitle = Scan.nextLine().trim();
		System.out.print("작성자명 >> ");
		String boardWriter = Scan.nextLine().trim();
		
		BoardVO bv1 = new BoardVO();
		bv1.setBoardNo(boardNo);
		bv1.setBoardTitle(boardTitle);
		bv1.setBoardWriter(boardWriter);
		
		List<BoardVO> bList = boardService.searchBoard(bv1);
		
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println(" NO\t제   목\t작성자명\t작성일자\t내   용");
		System.out.println("----------------------------------------------------------");
		
		if (bList.size() == 0) {
			System.out.println(" 검색된 게시글이 없습니다.");
		} else {
			for (BoardVO bv2 : bList) {
				System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTitle() + "\t" + bv2.getBoardWriter() + "\t" + bv2.getBoardDate() +  "\t" + bv2.getBoardContent());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("검색 끝 !");
		}	
	}
	  
	
	private boolean checkBoard(String boardNo) {

		boolean isExist = boardService.checkBoard(boardNo);

		return isExist;
	}

}

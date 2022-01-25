package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/detail.do")
public class DetailBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String boardNo = req.getParameter("boardNo");
		String boardNo = "6";
		
		System.out.println(boardNo);
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		
		BoardVO bv = boardService.getBoard(boardNo);
		
		System.out.println(bv);
		
		req.setAttribute("bv", bv);
		
		req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

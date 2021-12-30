<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
%>   
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자명</th>
			<th>작성일자</th>
			<th>내용</th>
		</tr>
		<%
			int boardSize = boardList.size();
			if (boardSize > 0) {
				for (int i = 0; i < boardSize; i++) {
		%>
		<tr>
			<td><%=boardList.get(i).getBoardNo() %></td>
			<td><%=boardList.get(i).getBoardTitle() %></td>
			<td><%=boardList.get(i).getBoardWriter() %></td>
			<td><%=boardList.get(i).getBoardDate() %></td>
			<td><%=boardList.get(i).getBoardContent() %></td>
		</tr>
		<%
				}
			} else {
		%>	
		<tr>
			<td colspan="4">게시판 글 정보가 없습니다.</td>
		</tr>
		<%
			}
		%>
	
	</table>
</body>
</html>
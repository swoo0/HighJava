<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardVO bv = (BoardVO) request.getAttribute("bv");
	

	System.out.println("z");
// 	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>제목:</td>
			<td><%=bv.getBoardTitle() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=bv.getBoardWriter() %></td>
		</tr>
		<tr>
			<td>작성일자:</td>
			<td><%=bv.getBoardDate() %></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=bv.getBoardContent() %></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>기존 첨부파일:</td> -->
<!-- 			<td> -->
			
<!-- 			</td> -->
<!-- 		</tr> -->
		<tr>
			<td>
				<a href="list.do">[목록]</a>
				<a href="update.do?boardNo=<%=bv.getBoardNo() %>">[게시글 수정]</a>
				<a href="delete.do?boardNo=<%=bv.getBoardNo() %>">[게시글 삭제]</a>
			</td>
		</tr>
	</table>
<%-- 	<%
		if (msg.equals("성공")) {
			
	%>
		<script>
			alert("성공했습니다.")
		</script>
	<%
		}
	%> --%>
</body>
</html>
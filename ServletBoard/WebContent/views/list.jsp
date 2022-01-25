<%@page import="vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input{
	margin-top: 20px;
}
</style>
</head>
<body>
<h2>삭제 수정 하려면 작성자 클릭ㄱㄱ</h2>
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>내용</td>
		<td>날짜</td>
	</tr>
	<%
	if(!list.isEmpty()){
		for(int i = 0; i < list.size(); i++){
	%>
	<tr>
		<td><%=list.get(i).getNum() %></td>
		<td><%=list.get(i).getTitle() %></td>
		<td><a href="detail.do?writer=<%=list.get(i).getWriter()%>"><%=list.get(i).getWriter() %></a></td>
		<td><%=list.get(i).getContent() %></td>
		<td><%=list.get(i).getDate() %></td>
	</tr>
	<% 
		} //for end
	} else{
	%>
	<tr>
		<td colspan="4">게시글이 존재하지 않습니다.</td>
	</tr>
	<%
	}
	%>
</table>
	<div>
		<input type="button" value="메인ㄱㄱ" onclick="goHome();">
	</div>
	<script>
		function goHome(){
			location.href="/ServletBoard/views/main.jsp";
		}
	</script>
</body>
</html>
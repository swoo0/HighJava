<%@page import="java.util.List"%>
<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("searchList");
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
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>내용</td>
		<td>날짜</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<%
	if(!list.isEmpty()){
		for(int i = 0; i < list.size(); i++){
	%>
	<tr>
		<td><%=list.get(i).getNum() %></td>
		<td><%=list.get(i).getTitle() %></td>
		<td><%=list.get(i).getWriter() %></td>
		<td><%=list.get(i).getContent() %></td>
		<td><%=list.get(i).getDate() %></td>
		<td><a href = "/ServletBoard/views/updateBoardForm.jsp?num=<%=list.get(i).getNum()%>">[수정ㄱ?]</a></td>
		<td><a href = "delete.do?num=<%=list.get(i).getNum()%>">[삭제ㄱ?]</a></td>
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
		<input type="button" value="뒤로가기" onclick="goBack();">
	</div>
	<script>
		function goHome(){
			location.href="/ServletBoard/views/main.jsp";
		}
		
		function goBack(){
			window.history.go(-1);
		}
	</script>
</body>
</html>
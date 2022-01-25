<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = request.getAttribute("msg") == null ? "" : (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 ㅋㅋ</h1>
<ul>
	<li><a href="/ServletBoard/views/insertBoardForm.jsp">게시글 작성</a></li>
	<li><a href="list.do">게시글 목록 및 관리</a></li>
</ul>
<script>
	<%
	if(msg.equals("성공")){
	%>
		alert("게시글 작성 성공!");	
	<%
	} else if(msg.equals("수정성공")){
	%>
		alert("게시글 수정 성공!");	
	<%
	} else if(msg.equals("삭제성공")){
	%>
		alert("게시글 삭제 성공!");	
	<%
	}
	%>
	</script>
</body>
</html>
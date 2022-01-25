<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<form action="update.do" method="post">
		<table>
			<tr>
				<td>제목 : </td>
				<td><%=num%><input type="hidden" name="num" value="<%=num%>"></td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="title" value=""></td>
			</tr>
			<tr>
				<td>작성자 : </td>
				<td><input type="text" name="writer" value=""></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea name="content" rows="3" cols="20"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="button" value="뒤로가기" onclick="goBack();">
</form>	
<script>
	function goBack(){
		window.history.go(-1);
	}
</script>
</body>
</html>
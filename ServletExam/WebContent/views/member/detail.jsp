<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO mv = (MemberVO) request.getAttribute("mv");
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
			<td>이름:</td>
			<td><%=mv.getMemName() %>
		</tr>
		<tr>
			<td>전화번호:</td>
			<td><%=mv.getMemTel() %>
		</tr>
		<tr>
			<td>주소:</td>
			<td><%=mv.getMemAddr() %>
		</tr>
		<tr>
			<td colspan="2">
				<a href="list.do">[목록]</a>
				<a href="update.do?memId=<%=mv.getMemId() %>">[회원정보 수정]</a>
				<a href="delete.do?memId=<%=mv.getMemId() %>">[회원정보 삭제]</a>
			</td>
		</tr>	
	</table>
	
	
</body>
</html>
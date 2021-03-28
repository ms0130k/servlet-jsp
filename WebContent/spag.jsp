<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
String val = (String) request.getAttribute("key");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/spag" method="GET">
		<input type="text" name="num" value="<%=num %>">
		<input type="submit" value="제출">
	</form>
	<div><%=val%></div>
</body>
</html>
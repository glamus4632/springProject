<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>test</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
<h1>로그인</h1>
<form action="<%= request.getContextPath() %>/"  method="GET">
	<input type="text" name="id">
	<input type="text" name="pw">
	<button class="btn btn-primary">로그인</button>
	<button>전송</button>
</form>
<br>
<a href="<%= request.getContextPath() %>/signup">회원가입</a>
</body>
</html>

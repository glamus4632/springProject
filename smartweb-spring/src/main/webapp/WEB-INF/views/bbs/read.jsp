<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lead</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/bbs/read" method="GET">
<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" readonly="readonly" value="${ user.id }">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" readonly="readonly"></textarea>
	</div>
</form>
</body>
</html>
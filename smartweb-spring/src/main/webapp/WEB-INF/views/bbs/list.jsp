<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<body>
로그인에 성공하셨습니다.
${user.id}님 환영합니다<!-- 세션에 저장하면 getAttribute 없이 사용 가능하다 -->
<a href="<%= request.getContextPath() %>/bbs/register">게시판으로 이동</a>
</body>
</html>
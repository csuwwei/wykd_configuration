<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="http://localhost:9021/wykd-jiadian/jiadianRedirectService/login">
		账号：<input name="username"/>
		密码：<input name="password" type="password"/>
		<input type="hidden" name="redirectUrl" value="${redirectUrl}" >
		<input type="submit" value="提交" />
	</form>
</body>
</html>
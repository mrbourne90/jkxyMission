<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<div id="login">
		<h1>Plese login here</h1>
		<form action="login.html" method="post">
			<input name="username" type="text" required="required"
				placeholder="用户名">
			<input name="password" type="password" required="required"
				placeholder="密码">
			<button class="but" type="submit">登录</button>
		</form>
		<h6>用户：admin 123456</h6>
	</div>
</body>
</html>
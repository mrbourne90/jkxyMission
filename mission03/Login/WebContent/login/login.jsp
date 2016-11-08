<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<script type="text/javascript" src="../js/login.js"></script>
</head>
<body>
	<form action="handle_login.jsp" method="post">
		<div id="login">
			<div id="login-head">
				<p>用户登录</p>
			</div>
			<div id="content">
				用户名：<input type="text" class="input" name="userName" id="userName" autofocus onblur="checkUserName()"><br/>
				密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" class="input" name="password" id="password" onblur="checkPassword()" onmouseleave="checkSubmit()"/>
				 <div><span id="note"></span><br/></div>
				<ul>
					<li><input type="submit" id="submit" value="提交" disabled="true"/></li>
					<li><input type="reset" value="重置" onclick="checkReset()"/></li>
				</ul>
			</div>
		</div>
	</form>
</body>
</html>
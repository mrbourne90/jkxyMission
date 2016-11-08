<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vip消费查询系统</title>
</head>
<body>
	<s:if test="#session.user!= null">
		<jsp:forward page="/index/welcome.jsp"></jsp:forward>
	</s:if>
	<div id="login">
		<h1>Plese login here</h1>
		<s:form action="/login_check" method="post">
			<input name="username" type="text" required="required"
				placeholder="用户名">
			<input name="password" type="password" required="required"
				placeholder="密码">
			<button class="but" type="submit">登录</button>
		</s:form>
		<h5>
			<s:property value="#session.msg" />
		</h5>
		<h6>管理员：admin 123456 普通用户：john 123456</h6>
	</div>
</body>
</html>
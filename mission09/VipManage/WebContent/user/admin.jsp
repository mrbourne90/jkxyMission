<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统维护</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>系统维护</h1>
			<hr align="center" color="#D0D0D0" size="1">
			<s:form action="/login_deactivate" method="post">
				<ul>
					<li><input name="username" class="input" type="text"
						required="required" placeholder="输入用户名 禁用或启用..."></li>
					<li><button class="but" type="submit">禁用</button></li>
					<li><button class="but" type="submit"
							onclick="this.form.action='/VipManage/login_activate'">启用</button></li>
				</ul>
			</s:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
		<div id="login">
			<div id="login-head">
				<p>用户详情</p>
			</div>
			<div id="content">
				<table cellspacing="0" cellpadding="2" border="0"
					bordercolor="#D6A858">
					<tr>
						<td>用户名：</td>
						<td><s:property value="user.userName"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><s:property value="user.password"/></td>
					</tr>
					<tr>
						<td>真实姓名：</td>
						<td><s:property value="user.realName"/></td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><s:property value="user.age"/></td>
					</tr>
					<tr>
						<td>手机号：</td>
						<td><s:property value="user.phoneNum"/></td>
					</tr>
					<tr>
						<td>住址：</td>
						<td><s:property value="user.address"/></td>
					</tr>
				</table>
			</div>
		</div>
</body>
</html>
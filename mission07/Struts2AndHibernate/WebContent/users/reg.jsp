<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<s:form action="User_register" method="post">
		<div id="login">
			<div id="login-head">
				<p>用户注册</p>
			</div>
			<div id="content">
				<table cellspacing="0" cellpadding="2" border="0"
					bordercolor="#D6A858">
					<tr>
						<td>用户名：</td>
						<td><input type="text" class="input" name="userName"
							id="userName" autofocus onblur="checkUserName()" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" class="input" name="password"
							id="password" onblur="checkPassword()" /></td>
					</tr>
					<tr>
						<td>真实姓名：</td>
						<td><input type="text" class="input" name="realName" /></td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><input type="number" class="input" name="age" /></td>
					</tr>
					<tr>
						<td>手机号：</td>
						<td><input type="text" class="input" name="phoneNum" /></td>
					</tr>
					<tr>
						<td>住址：</td>
						<td><input type="text" class="input" name="address" /></td>
					</tr>
				</table>
				<div>
					<span id="note"></span><br/>
				</div>
				<ul>
					<li><input type="submit" id="submit" value="注册"
						disabled="true" /></li>
					<li><input type="reset" value="重置" onclick="checkReset()" /></li>
				</ul>
				<div>
					<s:if test='regResult=="success"'><span id="ok">注册成功</span><a href="${pageContext.request.contextPath}/users/login.jsp">立即登录</a> </s:if>
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>
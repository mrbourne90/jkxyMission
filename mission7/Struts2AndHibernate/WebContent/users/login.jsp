<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
	<s:form action="User_login" method="post">
		<div id="login">
			<div id="login-head">
				<p>用户登录</p>
			</div>
			<div id="content">
				用户名：<input type="text" class="input" name="userName" id="userName" autofocus onblur="checkUserName()"><br/>
				密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" class="input" name="password" id="password" onblur="checkPassword()" onmouseleave="checkSubmit()"/>
				 <div><span id="note"></span><br/></div>
				  <div>
				  <s:if test='loginResult=="fail"'>不存在此用户</s:if>
				  </div>
				<ul>
					<li><input type="submit" id="submit" value="提交" disabled="true"/></li>
					<li><input type="reset" value="重置" onclick="checkReset()"/></li>
				</ul>
				 <div>
				  <a href="${pageContext.request.contextPath}/users/reg.jsp">立即注册</a>
				  <a href="${pageContext.request.contextPath}/users/User_show">用户管理</a>
				 </div>
			</div>
		</div>
	</s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/login.css">
<title>欢迎界面</title>
</head>
<body>
	<div id="login">
		<div id="login-head">
			<p>用户登录</p>
		</div>
		<div id="content">
			<%
				if (session.getAttribute("userName") != null && session.getAttribute("password") != null) {
			%>
			<div class="result">
				<span> 
					用户名：<%=session.getAttribute("userName")%><br /> 
					密码：<%=session.getAttribute("password")%><br />
					<a href="logout.jsp">注销</a>
				</span>
			</div>

			<%
				} else {
			%>
			<div class="result">
				<span> 
					您没有登录，请登录。
				</span>
			</div>
			
			<%
				response.setHeader("refresh", "2;URL=login.jsp");
			%>

			<%
				}
			%>
		</div>
	</div>

</body>
</html>
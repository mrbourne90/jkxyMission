<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<div id="login">
		<div id="login-head">
			<p>用户管理</p>
		</div>
		<div id="content">
			<table cellspacing="0" border="1" cellpadding="5" align="center"
				bordercolor="#E8E8E8">
				<tr align="center" bgcolor="#E8E8E8">
					<td>用户名</td>
					<td>查看操作</td>
					<td>删除操作</td>
				</tr>
				<%--使用Structs标签获取数据并输出 --%>
				<s:iterator value="users" var="user" status="st">
					<%--隔行换背景色 --%>
					<s:if test="#st.even">
						<tr bgcolor="#E8E8E8">
							<td><s:property value="#user.userName" /></td>
							<td><s:a href="User_get?id=%{#user.id}">查看</s:a></td>
							<td><s:a href="User_delete?id=%{#user.id}"
									onclick="return confirm('你确定要删除该记录吗？');">删除</s:a></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td><s:property value="#user.userName" /></td>
							<td><s:a href="User_get?id=%{#user.id}">查看</s:a></td>
							<td><s:a href="User_delete?id=%{#user.id}"
									onclick="return confirm('你确定要删除该记录吗？');">删除</s:a></td>
						</tr>
					</s:else>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
	<div id="header">
		<span>商场VIP消费情况查询系统</span> <a class="button" href="/VipManage/login_logout" target="_top">退出</a>
		<a class="button" href="/VipManage/index/help.jsp" target="_top">帮助</a> <a class="button" href="/VipManage/index/welcome.jsp"
			target="_top"><s:property value="#session.user.username" /></a>
	</div>
</body>

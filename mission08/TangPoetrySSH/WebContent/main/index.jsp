<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css">
<title>全唐诗</title>
</head>
<frameset rows="25%, *" border=0 framespacing="2">
	<frame src="${pageContext.request.contextPath}/main/top.jsp">
	<frameset cols="20%, *" border=0 framespacing="2">
		<frame src="${pageContext.request.contextPath}/main/inputCondition.jsp">
		<frame src="${pageContext.request.contextPath}/main/displayContentDefault.jsp" name="displayContent">
	</frameset>
</frameset>
<body></body>
</html>
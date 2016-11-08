<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/poeties.js"></script>
<title>Insert title here</title>
</head>
<body>
	<s:form action="getPoetries" method="post" name="search"
		target="displayContent">
		<table cellspacing="0" cellpadding="2" border="0"
			bordercolor="#D6A858">
			<tr>
				<td>搜索条件：</td>
				<td>
				<s:select name="searchCondition" list="#{'poet':'诗人','title':'标题','content':'内容'}" />
					</td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input name="searchKey" onkeyup="value=value.replace(/[^\u4E00-\u9FA5\u3002\uff1f\uff01\uff0c]/g,'')" onpaste="value=value.replace(/[^\u4E00-\u9FA5\u3002\uff1f\uff01\uff0c]/g,'')" oncontextmenu="value=value.replace(/[^\u4E00-\u9FA5\u3002\uff1f\uff01\uff0c]/g,'')"></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="搜索"
					onclick="return check(this)"></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red" id="msg"></span></td>
			</tr>
		</table>

	</s:form>

</body>
</html>
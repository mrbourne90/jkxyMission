<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/layout.css">
<script type="text/javascript" src="js/poeties.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/queryServlet"
		method="post" name="search" target="displayContent">
		<table cellspacing="0" cellpadding="2" border="0"
			bordercolor="#D6A858">
			<tr>
				<td>搜索条件：</td>
				<td><select name="searchCondition">
						<option value="poet">诗人</option>
						<option value="title">名称</option>
						<option value="content">内容</option>
				</select></td>
			</tr>
			<tr>
				<td>关键字：</td>
				<td><input type="text" name="searchKey"></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="搜索"
					onclick="return check(this)"></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red" id="msg"></span>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/layout.css">
<script type="text/javascript" src="js/poeties.js"></script>
<script type="text/javascript">
	//关键字高亮
	function key() {
		var content = document.getElementById('content').innerHTML;
		document.getElementById('content').innerHTML = content.replace(
				/${requestScope.searchKey}/g,
				"<span class=keyword>${requestScope.searchKey}</span>");
		//超出范围不允许提交
		document.getElementById("previous").style.visibility="visible";
		document.getElementById("next").style.visibility="visible";
		if (${requestScope.page.getCount()} == 1) {
			document.getElementById("previous").style.visibility="hidden";
		}
		if(${requestScope.page.getCount()} == ${requestScope.page.getTotal()}){
			document.getElementById("next").style.visibility="hidden";
			}
	}
	//跳转页面
	function goTo(pageIndex) {
		document.forms.form1.index.value = pageIndex;
		document.forms.form1.submit();
		return;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="key()">

	<table cellspacing="0" border="1" cellpadding="5" align="center"
		id="content" bordercolor="#E8E8E8">
		<tr align="center" bgcolor="#D6A858">
			<td width="80px">诗人</td>
			<td width="240px">诗题</td>
			<td>内容</td>
		</tr>
		<%--使用JSTL获取数据并输出 --%>
		<c:forEach items="${requestScope.poetries}" var="poetry"
			varStatus="status">
			<%--隔行换背景色 --%>
			<tr <c:if test="${status.count%2==0}">bgcolor="#E8E8E8"</c:if>>
				<td>${poetry.getPoetName()}</td>
				<td>${poetry.getTitle()}</td>
				<td>${poetry.getContent()}</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<form name="form1"
			action="${pageContext.request.contextPath}/queryServlet"
			method="post">
			<table cellspacing="0" border="0" cellpadding="5" align="center">
				<tr>
					<td><input type="hidden" name="searchKey"
						value="${requestScope.searchKey }"> <input type="hidden"
						name="searchCondition" value="${requestScope.searchCondition }">
						<input type="hidden" name="index"></td>
					<td><span id="msg" class=keyword></span></td>
				</tr>
				<tr>
					<td>${requestScope.page.getTotalRow()}条结果</td>
					<td>当前为第 ${requestScope.page.getCount()}页</td>
					<td>共${requestScope.page.getTotal()}页</td>
					<td><a id="previous"
						href="javascript:goTo(${requestScope.page.getCount() - 1 })">上一页</a></td>
					<td><a id="next"
						href="javascript:goTo(${requestScope.page.getCount() + 1 })">下一页</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
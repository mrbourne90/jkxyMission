<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/poeties.js"></script>
<script type="text/javascript">
	//关键字高亮
	function replaceKey() {
		var content = document.getElementById('content').innerHTML;
		document.getElementById('content').innerHTML = content.replace(
				/${key}/g, "<span class=keyword>${key}</span>");
	}
	//跳转页面
	function goTo(pageNo) {
		document.forms.form1.pageNo.value = pageNo;
		document.forms.form1.submit();
		return;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="replaceKey()">
	<table cellspacing="0" border="1" cellpadding="5" align="center"
		id="content" bordercolor="#E8E8E8">
		<tr align="center" bgcolor="#D6A858">
			<td width="80px">诗人</td>
			<td width="240px">诗题</td>
			<td>内容</td>
		</tr>
		<c:forEach var="item" items="${poetryPage.datas}" varStatus="status">
			<tr <c:if test="${status.count%2==0}">bgcolor="#F0F0F0"</c:if>
				align="left">
				<td width="80px">${item.poet.name }</td>
				<td width="240px">${item.title }</td>
				<td>${item.content }</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<form name="form1" action="findPoetry.html" method="post">
			<table cellspacing="0" border="0" cellpadding="5" align="center">
				<tr>
					<td>
						<!-- 隐藏的参数 --> <input name="key" type="hidden" value="${key }">
						<input name="condition" type="hidden" value="${condition }">
						<input name="pageNo" type="hidden" value="${poetryPage.pageNo }">
					</td>
				</tr>
				<tr>
					<td>${poetryPage.recordCount }条结果</td>
					<td>当前为第${poetryPage.pageNo }页</td>
					<td>共${poetryPage.pageCount }页</td>
					<c:if test="${poetryPage.hasFirst }">
						<td><a id="first" href="javascript:goTo(1)">首页</a></td>
					</c:if>
					<c:if test="${poetryPage.hasLast }">
						<td><a id="last"
							href="javascript:goTo(${poetryPage.pageCount })">尾页</a></td>
					</c:if>
					<c:if test="${poetryPage.hasPrev }">
						<td><a id="previous"
							href="javascript:goTo(${poetryPage.pageNo - 1 })">上一页</a></td>
					</c:if>
					<c:if test="${poetryPage.hasNext }">
						<td><a id="next"
							href="javascript:goTo(${poetryPage.pageNo + 1 })">下一页</a></td>
					</c:if>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
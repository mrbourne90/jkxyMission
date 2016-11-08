<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
				/<s:property value="searchKey"/>/g,
				"<span class=keyword><s:property value="searchKey"/></span>");
		//超出范围不允许提交
		document.getElementById("previous").style.visibility = "visible";
		document.getElementById("next").style.visibility = "visible";
		if (<s:property value="poetries.pageNo"/> == 1) {
			document.getElementById("previous").removeAttribute("href");
			document.getElementById("first").removeAttribute("href");
		}
		if (<s:property value="poetries.pageCount"/> == <s:property value="poetries.pageNo"/>) {
			document.getElementById("next").removeAttribute("href");
			document.getElementById("last").removeAttribute("href");
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
<body onload="replaceKey()">
	<table cellspacing="0" border="1" cellpadding="5" align="center"
		id="content" bordercolor="#E8E8E8">
		<tr align="center" bgcolor="#D6A858">
			<td width="80px">诗人</td>
			<td width="240px">诗题</td>
			<td>内容</td>
		</tr>
		<%--使用Structs标签获取数据并输出 --%>
		<s:iterator value="poetries.datas" var="poetry" status="st">
			<%--隔行换背景色 --%>
			<s:if test="#st.even">
				<tr bgcolor="#E8E8E8">
					<td><s:property value="#poetry.poet.name" /></td>
					<td><s:property value="#poetry.title" /></td>
					<td><s:property value="#poetry.content" /></td>
				</tr>
			</s:if>
			<s:else>
				<tr>
					<td><s:property value="#poetry.poet.name" /></td>
					<td><s:property value="#poetry.title" /></td>
					<td><s:property value="#poetry.content" /></td>
				</tr>
			</s:else>
		</s:iterator>
	</table>
	<div align="center">
		<s:form name="form1" action="getPoetries" method="post">
			<table cellspacing="0" border="0" cellpadding="5" align="center">
				<tr>
					<td><s:textfield name="searchKey" type="hidden"></s:textfield>
						<s:textfield name="searchCondition" type="hidden"></s:textfield> <s:textfield
							name="index" type="hidden"></s:textfield>
					<td><span id="msg" class=keyword></span></td>
				</tr>
				<tr>
					<td><s:property value="poetries.recordCount" />条结果</td>
					<td>当前为第<s:property value="poetries.pageNo" />页
					</td>
					<td>共<s:property value="poetries.pageCount" />页
					</td>
					<td><a id="first" href="javascript:goTo(1)">首页</a></td>
					<td><a id="last" href="javascript:goTo(<s:property value="poetries.pageCount"/>)">尾页</a></td>
					<td><a id="previous"
						href="javascript:goTo(<s:property value="poetries.pageNo-1"/>)">上一页</a></td>
					<td><a id="next"
						href="javascript:goTo(<s:property value="poetries.pageNo+1"/>)">下一页</a></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
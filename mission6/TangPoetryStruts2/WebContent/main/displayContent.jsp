<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/poeties.js"></script>
<script type="text/javascript">
	//关键字高亮
	function key() {
		var content = document.getElementById('content').innerHTML;
		document.getElementById('content').innerHTML = content.replace(
				/<s:property value="searchKey"/>/g,
				"<span class=keyword><s:property value="searchKey"/></span>");
		//超出范围不允许提交
		document.getElementById("previous").style.visibility="visible";
		document.getElementById("next").style.visibility="visible";
		if (<s:property value="page.count"/> == 1) {
			document.getElementById("previous").style.visibility="hidden";
		}
		if(<s:property value="page.count"/> == <s:property value="page.total"/>){
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
		<%--使用Structs标签获取数据并输出 --%>
		<s:iterator value="poetries" var="poetry" status="st">
			<%--隔行换背景色 --%>
			<s:if test="#st.even">
				<tr bgcolor="#E8E8E8">
					<td><s:property value="#poetry.poetName" /></td>
					<td><s:property value="#poetry.title" /></td>
					<td><s:property value="#poetry.content" /></td>
				</tr>
			</s:if>
			<s:else>
				<tr>
					<td><s:property value="#poetry.poetName" /></td>
					<td><s:property value="#poetry.title" /></td>
					<td><s:property value="#poetry.content" /></td>
				</tr>
			</s:else>
		</s:iterator>
	</table>
	<div align="center">
		<s:form name="form1" action="poetry" method="post">
			<table cellspacing="0" border="0" cellpadding="5" align="center">
				<tr>
					<td>
					<s:textfield name="searchKey" type="hidden"></s:textfield>
					<s:textfield name="searchCondition"  type="hidden"></s:textfield>
					<s:textfield name="index"  type="hidden"	></s:textfield>
					<td><span id="msg" class=keyword></span></td>
				</tr>
				<tr>
					<td><s:property value="page.rowTotal"/>条结果</td>
					<td>当前为第<s:property value="page.count"/>页</td>
					<td>共<s:property value="page.total"/>页</td>
					
					<td><a id="previous"
						href="javascript:goTo(<s:property value="page.count-1"/>)">上一页</a></td>
					<td><a id="next"
						href="javascript:goTo(<s:property value="page.count+1"/>)">下一页</a></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
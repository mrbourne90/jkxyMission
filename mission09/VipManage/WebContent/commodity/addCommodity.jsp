<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息录入</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>商品信息录入</h1>
			<hr align="center" color="#D0D0D0" size="1">
			<s:form action="/commodity_add" method="post">
				<ul id="thead">
					<li>商品编号</li>
					<li>商品名称</li>
					<li>商品价格(元)</li>
					<li>商品折扣(%)</li>
				</ul>
				<button class="but" type="reset">重置</button>
				<hr align="center" color="#D0D0D0" size="1">
				<ul>
					<li><input class="input" type="text" placeholder="自动递增"
						disabled="disabled"></li>
					<li><input name="commodityName" class="input" type="text" required="required"></li>
					<li><input name="price" class="input" type="number"  oninput="if(value.length>6)value=value.slice(0,6)" required="required"></li>
					<li><input name="agio" class="input" type="number" oninput="if(value.length>3)value=value.slice(0,3)" required="required"></li>
				</ul>
				<button class="but" type="submit">添加</button>
			</s:form>
		</div>
	</div>
</body>
</html>
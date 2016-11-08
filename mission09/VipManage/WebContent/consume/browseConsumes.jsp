<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP购物登记</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>VIP购物登记</h1>
			<hr align="center" color="#D0D0D0" size="1">
			<s:action name="consume_browse" namespace="/"></s:action>
			<ul id="thead">
				<li>消费ID</li>
				<li>VIP编号</li>
				<li>姓名</li>
				<li>商品编号</li>
				<li>商品名称</li>
				<li>商品价格</li>
				<li>实收金额</li>
			</ul>
			<s:iterator value="#session.consumesPage.getContent" var="consume"
				status="st">
				<s:if test="#st.even">
					<ul class="evenRow">
						<li><s:property value="#consume.consumeId" /></li>
						<li><s:property value="#consume.vip.vipId" /></li>
						<li><s:property value="#consume.name" /></li>
						<li><s:property value="#consume.commodity.commodityId" /></li>
						<li><s:property value="#consume.commodityName" /></li>
						<li><s:property value="#consume.formatPrice" /></li>
						<li><s:property value="#consume.formatPracticePrice" /></li>
					</ul>
				</s:if>
				<s:else>
					<ul class="oddRow">
						<li><s:property value="#consume.consumeId" /></li>
						<li><s:property value="#consume.vip.vipId" /></li>
						<li><s:property value="#consume.name" /></li>
						<li><s:property value="#consume.commodity.commodityId" /></li>
						<li><s:property value="#consume.commodityName" /></li>
						<li><s:property value="#consume.formatPrice" /></li>
						<li><s:property value="#consume.formatPracticePrice" /></li>
					</ul>
				</s:else>
			</s:iterator>
			<ul class="footer">
				<li><s:if test="#session.consumesPage.getNumber!=0">
						<a href="/VipManage/consume_browse?pageNo=0"><button class="pagebut">首页</button></a>
						<a
							href="/VipManage/consume_browse?pageNo=<s:property value="#session.consumesPage.getNumber-1" />"><button
								class="pagebut">上页</button></a>
					</s:if></li>
				<li><s:if
						test="#session.consumesPage.getNumber+1 != #session.consumesPage.getTotalPages">
						<a
							href="/VipManage/consume_browse?pageNo=<s:property value="#session.consumesPage.getNumber+1" />"><button
								class="pagebut">下页</button></a>
						<a
							href="/VipManage/consume_browse?pageNo=<s:property value="#session.consumesPage.getTotalPages-1" />"><button
								class="pagebut">尾页</button></a>
					</s:if></li>
				<li>当前第<s:property value="#session.consumesPage.getNumber+1" />页&nbsp共<s:property
						value="#session.consumesPage.getTotalPages" />页
				</li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息查询</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>商品信息查询</h1>
			<hr align="center" color="#D0D0D0" size="1">
			<s:action name="commodity_browse" namespace="/"></s:action>
			<s:form action="/commodity_findOne" method="post">
				<ul>
					<li><input name="commodityId" class="input" type="number"
						required="required" placeholder="请输入商品编号..."></li>
					<li><button type="submit" class="pagebut">查找</button></li>
					<li></li>
				</ul>
			</s:form>
			<ul id="thead">
				<li>商品编号</li>
				<li>商品名称</li>
				<li>商品价格(元)</li>
				<li>商品折扣(%)</li>
			</ul>
			<s:if test="#request.commodityResult!=null">
				<ul class="oddRow">
					<li><s:property value="#request.commodityResult.commodityId" /></li>
					<li><s:property value="#request.commodityResult.commodityName" /></li>
					<li><s:property
							value="#request.commodityResult.getFormatPrice" /></li>
					<li><s:property value="#request.commodityResult.getFormatAgio" /></li>
				</ul>
			</s:if>
			<s:else>
				<s:iterator value="#session.commodityPage.getContent"
					var="commodity" status="st">
					<s:if test="#st.even">
						<ul class="evenRow">
							<li><s:property value="#commodity.commodityId" /></li>
							<li><s:property value="#commodity.commodityName" /></li>
							<li><s:property value="#commodity.getFormatPrice" /></li>
							<li><s:property value="#commodity.getFormatAgio" /></li>
						</ul>
					</s:if>
					<s:else>
						<ul class="oddRow">
							<li><s:property value="#commodity.commodityId" /></li>
							<li><s:property value="#commodity.commodityName" /></li>
							<li><s:property value="#commodity.getFormatPrice" /></li>
							<li><s:property value="#commodity.getFormatAgio" /></li>
						</ul>
					</s:else>
				</s:iterator>
				<ul class="footer">
					<li><s:if test="#session.commodityPage.getNumber!=0">
							<a href="/VipManage/commodity_browse?pageNo=0"><button class="pagebut">首页</button></a>
							<a
								href="/VipManage/commodity_browse?pageNo=<s:property value="#session.commodityPage.getNumber-1" />"><button
									class="pagebut">上页</button></a>
						</s:if></li>
					<li><s:if
							test="#session.commodityPage.getNumber+1 != #session.commodityPage.getTotalPages">
							<a
								href="/VipManage/commodity_browse?pageNo=<s:property value="#session.commodityPage.getNumber+1" />"><button
									class="pagebut">下页</button></a>
							<a
								href="/VipManage/commodity_browse?pageNo=<s:property value="#session.commodityPage.getTotalPages-1" />"><button
									class="pagebut">尾页</button></a>
						</s:if></li>
					<li>当前第<s:property value="#session.commodityPage.getNumber+1" />页&nbsp共<s:property
							value="#session.commodityPage.getTotalPages" />页
					</li>
					<li></li>
				</ul>
			</s:else>
		</div>
	</div>
</body>
</html>
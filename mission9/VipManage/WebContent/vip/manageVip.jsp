<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP信息管理</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>VIP信息管理</h1>
			<hr align="center" color="#D0D0D0" size="1">
			<s:action name="vip_browse" namespace="/"></s:action>
			<s:form action="/vip_add" method="post">
				<ul id="thead">
					<li>VIP编号</li>
					<li>姓名</li>
					<li>年龄</li>
					<li>成分</li>
				</ul>
				<button class="but" type="reset">重置</button>
				<hr align="center" color="#D0D0D0" size="1">
				<ul>
					<li><input class="input" type="text" placeholder="自动递增"
						disabled="disabled"></li>
					<li><input name="name" class="input" type="text"
						required="required"></li>
					<li><input name="age" class="input" type="number"
						required="required"></li>
					<li><input name="profession" class="input" type="text"
						required="required"></li>
				</ul>
				<button class="but" type="submit">添加</button>
			</s:form>
			<h3>VIP信息列表</h3>
			<ul id="thead">
				<li>VIP编号</li>
				<li>入会时间</li>
				<li>姓名</li>
				<li>年龄</li>
				<li>成分</li>
			</ul>
			<s:iterator value="#session.vipPage.getContent" var="vip" status="st">
				<s:if test="#st.even">
					<ul class="evenRow">
						<li><s:property value="#vip.vipId" /></li>
						<li><s:property value="#vip.formatJoinTime" /></li>
						<li><s:property value="#vip.name" /></li>
						<li><s:property value="#vip.age" /></li>
						<li><s:property value="#vip.profession" /></li>
					</ul>
				</s:if>
				<s:else>
					<ul class="oddRow">
						<li><s:property value="#vip.vipId" /></li>
						<li><s:property value="#vip.formatJoinTime" /></li>
						<li><s:property value="#vip.name" /></li>
						<li><s:property value="#vip.age" /></li>
						<li><s:property value="#vip.profession" /></li>
					</ul>
				</s:else>
			</s:iterator>
			<ul class="footer">
				<li><s:if test="#session.vipPage.getNumber!=0">
						<a href="/VipManage/vip_browse?pageNo=0"><button class="pagebut">首页</button></a>
						<a
							href="/VipManage/vip_browse?pageNo=<s:property value="#session.vipPage.getNumber-1" />"><button
								class="pagebut">上页</button></a>
					</s:if></li>
				<li><s:if
						test="#session.vipPage.getNumber+1 != #session.vipPage.getTotalPages">
						<a
							href="/VipManage/vip_browse?pageNo=<s:property value="#session.vipPage.getNumber+1" />"><button
								class="pagebut">下页</button></a>
						<a
							href="/VipManage/vip_browse?pageNo=<s:property value="#session.vipPage.getTotalPages-1" />"><button
								class="pagebut">尾页</button></a>
					</s:if></li>
				<li>当前第<s:property value="#session.vipPage.getNumber+1" />页&nbsp共<s:property
						value="#session.vipPage.getTotalPages" />页
				</li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
</body>
</html>
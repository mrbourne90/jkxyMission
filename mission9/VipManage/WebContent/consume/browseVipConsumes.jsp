<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/VipManage/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VI信息查询</title>
</head>
<body>
	<jsp:include page="/index/top.jsp"></jsp:include>
	<jsp:include page="/index/menu.jsp"></jsp:include>
	<div id="left">
		<div id="content">
			<h1>VIP信息查询</h1>
			<s:form action="/vip_findOne" method="post">
				<ul>
					<li><input name="vipId" class="input" type="number"
						required="required" placeholder="输入VIP编号 查询..."></li>
					<li><button class="but" type="submit">查询</button></li>
				</ul>
			</s:form>
			<s:if test="#request.vipResult!=null">
				<ul id="thead">
					<li>VIP编号</li>
					<li>姓名</li>
					<li>年龄</li>
					<li>成分</li>
				</ul>
				<ul class="oddRow">
					<li><s:property value="#request.vipResult.vipId" /></li>
					<li><s:property value="#request.vipResult.name" /></li>
					<li><s:property value="#request.vipResult.age" /></li>
					<li><s:property value="#request.vipResult.profession" /></li>
				</ul>
				<s:action name="consume_findByVipId" namespace="/"></s:action>
				<s:if test="#session.vipConsumes != null">
					<ul>
						<h3>VIP消费记录</h3>
					</ul>
					<ul id="thead">
						<li>消费ID</li>
						<li>VIP编号</li>
						<li>姓名</li>
						<li>商品编号</li>
						<li>商品名称</li>
						<li>商品价格</li>
						<li>实收金额</li>
					</ul>
					<s:iterator value="#session.vipConsumes.getContent" var="consume"
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
						<li><s:if test="#session.vipConsumes.getNumber!=0">
								<a href="/VipManage/consume_findByVipId?pageNo=0"><button class="pagebut">首页</button></a>
								<a
									href="/VipManage/consume_findByVipId?pageNo=<s:property value="#session.vipConsumes.getNumber-1" />"><button
										class="pagebut">上页</button></a>
							</s:if></li>
						<li><s:if
								test="#session.vipConsumes.getNumber+1 != #session.vipConsumes.getTotalPages">
								<a
									href="/VipManage/consume_findByVipId?pageNo=<s:property value="#session.vipConsumes.getNumber+1" />"><button
										class="pagebut">下页</button></a>
								<a
									href="/VipManage/consume_findByVipId?pageNo=<s:property value="#session.vipConsumesgetTotalPages-1" />"><button
										class="pagebut">尾页</button></a>
							</s:if></li>
						<li>当前第<s:property value="#session.vipConsumes.getNumber+1" />页&nbsp共<s:property
								value="#session.vipConsumes.getTotalPages" />页
						</li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</s:if>
			</s:if>
		</div>
	</div>
</body>
</html>
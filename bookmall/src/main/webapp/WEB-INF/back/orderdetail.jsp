<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'orderdetail.jsp' starting page</title>
</head>

<body>
	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
		<h3>订单明细</h3>
		<tr>
			<td>书名</td>
			<td>售价</td>
			<td>数量</td>
			<td>应收货款</td>
		</tr>

		<c:forEach var="od" items="${oItem}">
			<tr>
				<td>${od.price}</td>
				<td>${od.price }</td>
				<td>${od.quantity }</td>
				<td>${od.price }元</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">总计应收货款</td>
			<td colspan="2">${order.price }元</td>
		</tr>
	</table>
	<br />
	<br />
	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
		<h3>收货人详细地址</h3>
		<tr>
			<td>用户</td>
			<td>电话</td>
			<td>手机</td>
			<td>地址</td>
			<td>邮箱</td>
		</tr>

		<tr>

		</tr>
	</table>
	<br />
	<a href="${pageContext.request.contextPath }/#">确认发货</a>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'orderdetail.jsp' starting page</title>
</head>

<body onload="load()">
	<h3>订单明细</h3>
	<c:forEach items="${orderitem}" var="map">
		<table frame="border" cellpadding="0" cellspacing="0" width="90%">
			<tr>
				<td><span style="color:red;font-weight: bold;">订单：<c:out value="${map.key+1}"></c:out></span></td>
			</tr>
			<tr>
				<td>书名</td>
				<td>售价</td>
				<td>数量</td>
				<td>应收货款</td>
				<td>订单状态</td>
			</tr>

			<c:forEach items="${map.value}" var="od">
				<tr>
					<td>${od.book.name }</td>
					<td>${od.price/od.quantity}</td>
					<td>${od.quantity }</td>
					<td>${od.price }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:forEach>
</body>
</html>

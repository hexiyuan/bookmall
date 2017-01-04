<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>网上书店</h1>
<div>    
<div style="margin-left: 40%;float: left">
	<a href="${pageContext.request.contextPath }/front/index.front">首页</a>
	<a href="${pageContext.request.contextPath }/front/listcart.front">查看购物车</a>
	<a href="#">查看自己的订单</a>
</div>
 	
<div style="float: right;">
		<c:if test="${user==null}">
		<form action="${pageContext.request.contextPath }/front/login.front" method="post">
 			用户名：<input type="text" name="username" style="width: 50px">
 			密码：<input type="password" name="password" style="width: 50px">
 			<input type="submit" value="登陆">
 			<input type="button" value="注册" onclick="javascript:window.location.href='${pageContext.request.contextPath }/front/register.front'">
		</form>
		</c:if>
		<c:if test="${user!=null}">
			欢迎你：${user.username } <br><br>
			<a href="${pageContext.request.contextPath }/front/logout.front">退出</a>
		</c:if>
		
</div>
<div style="clear: both"></div>
</div>
<hr>

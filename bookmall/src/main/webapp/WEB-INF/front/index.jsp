<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="os" uri="http://www.opensymphony.com/oscache"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书商品前台首页</title>

<style type="text/css">
body {
	height: 100%;
	margin: 0px;
	padding: 0px;
	text-align: center;
}
#container {
	width: 100%;
	height: 300px;
	text-align: left;
}
#main {
	margin-top: 20px;
}
#head {
	text-align: center;
}
#categories {
	border: solid 1px;
	width: 250px;
	padding-left: 20px;
	height: 400px;
	line-height: 40px;
	float: left;
}
#books {
	float: left;
	margin-left: 50px;
}
#image {
	height: 120px;
	width: 120px;
	float: left;
}
#info {
	float: left;
	margin-left: 10px; height : 120px;
	width: 100px;
	height: 120px
}
#book {
	float: left;
	width: 230px;
}
</style>

</head>

<body>
	<div id="container">
		<div id="head">
			<%@include file="../front/head.jsp"%>
		</div>

		<div id="main">
			<div id="categories">
				分类列表：
				<c:forEach var="c" items="${categories}">
					<li><a id="categoryId" href='${pageContext.request.contextPath }/front/index.front?categoryId=${c.id }'
						name='categoryId' value='${c.id }'>${c.name }</a></li>
				</c:forEach>
			</div>


			<div id="books">
				<c:forEach var="book" items="${pagebean.list}" varStatus="status">
					<div id="book">
						<div id="image">
							<img height="120" width="120"
								src="http://localhost:8080/upload/${book.image }" />
						</div>
						<div id="info">
							<li>${book.name }</li>
							<li>${book.author }</li>
							<li>${book.price }</li>
							<li><a
								href="${pageContext.request.contextPath }/front/buy.front?id=${book.id }">购买</a>
							</li>
						</div>
						<div style="clear: both"></div>
					</div>
					<c:if test="${status.count%3==0}">
						<div style="clear: both"></div>
						<br />
					</c:if>
				</c:forEach>

				<div style="clear: both"></div>
				<br/>
				<div id="pagebar">

		共</span name='totalpage'>${pagebean.totalpage }</span>页 <span></span>
		
		<a href="${pageContext.request.contextPath }/front/index.front?currentpage=${pagebean.previouspage}&categoryId=${param.categoryId}" name='previouspage' value=${currentPage-1}"><< 前一页 </a><span></span> 
		
		当前第：<span name='currentpage' value='${pagebean.currentpage}'>${pagebean.currentpage}</span>页 <span></span>
		
		<a href="${pageContext.request.contextPath }/front/index.front?currentpage=${pagebean.nextpage}&categoryId=${param.categoryId}" name='nextpage' value=${currentPage+1}"> >> 后一页 </a><span></span>
		
		<!-- 每页:<input id="pagesize" name='pagesize' style="width: 25px;"></input>项</br> -->
		
				</div>
			</div>

		</div>
	</div>
</body>
</html>

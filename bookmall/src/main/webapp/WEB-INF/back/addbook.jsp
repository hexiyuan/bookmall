<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加图书</title>
<script src="../js/jquery.js" type="text/javascript"></script>
 <script src="../js/jquery.form.js" type="text/javascript"></script>

<script type="text/javascript">
    function uploadpic(){
    	var options = {
    		url:"http://localhost:8080/bookmall/back/uploadpic.back",
    		dataType:"json",
    		success:function(data){
    			//data包含两个路径，一个路径url，完整路径http:localhost:8080/imgweb/upload/abc.jpg，另一个是相对路径 path upload/abc.jpg
    			$("#product_url").attr("src",data.url);
    			$("#product_path").val(data.path);
    		}
    	};
    	$("#jvForm").ajaxSubmit(options);
    }
    
    </script>

</head>

<body>

	<br />
	<br />
	<form id="jvForm"
		action="${pageContext.request.contextPath }/back/addBookPage.back"
		method="post" enctype="multipart/form-data">
		<table width="500px">
			<tr>
				<td>书名</td>
				<td><input type="text" name="name" style="width: 200px"></td>
			<tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author" style="width: 200px"></td>
			</tr>
			<tr>
				<td>售价</td>
				<td><input type="text" name="price" style="width: 200px"></td>
			</tr>
			<tr>
				<td>图片</td>
				<!-- type="file"  -->
				<td><img width="100" height="100" id="product_url" border="1"
					style="width: 100px" /> <!-- 该隐藏输入框用来获得从json返回的路径名，当form表单在提交的时候将该路径提交给表单的controller -->
					<input type="hidden" name="image" id="product_path" /> <!-- 该输入框用来生成图片上传事件。 -->
					<input id="pic" type="file" name="pic" onchange="uploadpic()"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea rows="4" cols="40" name="description"></textarea></td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td><select name="category.id">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id }">${category.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="添加书籍"></td>
			</tr>
		</table>
	</form>

</body>
</html>

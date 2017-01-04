<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户表单注册中心</title>
<script type="text/javascript">
    	function check(){
    		var username = document.getElementById('username');
            var password = document.getElementById('password');
            var phone = document.getElementById('phone');
            var cellphone = document.getElementById('cellphone');
            var address = document.getElementById('address');
            var email = document.getElementById('email');
					if ((username.value) == null || (username.value) == "") {
							alert("请输入用户名");
							username.focus();
							return false;
						}
					if ((phone.value) == null || (phone.value) == "") {
						alert("请输入您的电话号码");
						username.focus();
						return false;
					}
					if ((cellphone.value) == null || (cellphone.value) == "") {
						alert("请输入你的移动手机号码");
						username.focus();
						return false;
					}
					if ((email.value) == null || (email.value) == "") {
						alert("请输入你的Email邮箱");
						username.focus();
						return false;
					}
					if ((address.value) == null || (address.value) == "") {
						alert("请输入你的住址");
						username.focus();
						return false;
					}
					if(trim(password.value)==null || trim(password.value)==""){
						    alert("请输入密码");
						    password.focus();
						    return false;
						}
						   return true;
					}
    	
		function trim(str){ //删除左右两端的空格
			return str.replace(/(^\s*)|(\s*$)/g, "");
						   }
</script>
</head>
  
  <body style="text-align: center">
    
    <form action="${pageContext.request.contextPath }/front/registerFrom.front" method="post" onsubmit="return check();">
    	<table width="300px" style="text-align: center">
    	<caption><h2>用户注册</h2></caption>
    	<tr>
    		<td>用户名</td>
    		<td><input id="username" type="text" name="username" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>密码</td>
    		<td><input id="password" type="password" name="password" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>电话</td>
    		<td><input id="phone" type="text" name="phone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>手机</td>
    		<td><input id="cellphone" type="text" name="cellphone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>住址</td>
    		<td><input id="address" type="text" name="address" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td>
    			<input  id="email" type="text" name="email" style="width: 200px">
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="注册" "></td>
    	</tr>
    	</table>
    </form>
    
    
  </body>
</html>

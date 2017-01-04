<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="os" uri="http://www.opensymphony.com/oscache" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<script src="../js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	var omg = new XMLHttpRequest();
	/* 核心对象，通过它来发送ajax请求  */
	/* oXmlHttp.open( "GET", "test.xml", false ) ;
	oXmlHttp.send(null) ; */

	/*  function findIp() {
		alert("Is coming!");
		var url = 'http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl';
		var ipAddress ="192.168.20.22"; 
		var sop = '<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
		'<soap:Body><getWeatherbyCityName xmlns="http://WebXml.com.cn/"><theCityName>广州</theCityName></getWeatherbyCityName></soap:Body></soap:Envelope>';
		//打开链接
		omg.open('POST', url, true);
	 	omg.setHeader('Access-Control-Allow-Origin:'); 
		//重新设置请求头
		omg.setRequestHeader('content-Type', 'text-xml;charset=UTF-8');
		//设置回调函数
		omg.onreadystatechange=_back;
		//发送请求
		omg.send(sop);
	}
	function _back() {
		if(omg.readyState == 4){
			if(omg.status == 200){
				alert("success");
			}
		}
		
	}  */
	
	
	function findIp() {
	$.ajax({
		url:'http://webservice.36wu.com/ipService.asmx?wsdl',
		type:'post',
		dataType:"xml",
		contentType:'text-xml;charset=UTF-8',
		date:'<soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope"><soap12:Body><getIPByUrl xmlns="Yangzhili"><Url>string</Url><UserId>www.baidu.com</UserId></getIPByUrl></soap12:Body></soap12:Envelope>',
		success:function(){alert("success")},
		error:function(){alert("error")}
	});
	}
</script>

</head>
<os:cache>
<body style="text-align: center">
	<div><big><h4>桃花庵歌---唐寅</h4></big></div>
	<div><h5>桃花坞里桃花庵，桃花庵下桃花仙。桃花仙人种桃树，又摘桃花换酒钱。</h5></div>
	<div><h5>酒醒只在花前坐，酒醉还来花下眠。半醉半醒日复日，花落花开年复年。</h5></div>
	<div><h5>但愿老死花酒间，不愿鞠躬车马前。车尘马足显者事，酒盏花枝隐士缘。</h5></div>
	<div><h5>若将显者比隐士，一在平地一在天。若将花酒比车马，彼何碌碌我何闲。</h5></div>
	<div><h5>别人笑我太疯癫，我笑他人看不穿。不见五陵豪杰墓，无花无酒锄作田。</h5></div>
</os:cache>

	请输入你所需要查询的IP：<input type="text" id="find"></input>
	<input type="button" id="sub" value="查询" onclick="findIp();">
	
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台左侧导航页面</title>
    
    <style type="text/css">
      .dc { 
      		display: block; 
      		margin-left: 10px;
      	  }
	</style>
	<script type="text/javascript">
	      function test(e) {
	            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;       
	      }
	</script>
  </head>
  
  <body>
    <ul>
    	<li>
    		<a href="#" onclick="test(children[0])">分类管理
    			<div class="dc">
	    			<a href="${pageContext.request.contextPath }/back/addcategory.back"  target="right">添加分类</a><br/>
	    			<a href="${pageContext.request.contextPath }/back/listcategory.back"  target="right">查看分类</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">图书管理
    			<div class="dc">
	    				<a href="${pageContext.request.contextPath }/back/addbook.back"  target="right">添加图书</a><br/>
	    				<a href="${pageContext.request.contextPath }/back/listbook.back"  target="right">查看图书</a>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">订单管理
	    		<div class="dc">
	    			<a href="${pageContext.request.contextPath }/back/orderToResolve.back?state=0"  target="right">待处理订单</a><br/>
	    			<a href="${pageContext.request.contextPath }/back/orderToResolve.back?state=1"  target="right">已发货订单</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	

    	
    </ul>
  </body>
</html>

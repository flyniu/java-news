<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加新闻类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page123">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
	

 <script type="text/javascript">		
    	function dopost(){  	
    		var judge = true;
    		var nav_name = document.getElementById("nav_name").value;    		
    		var nav_feight = document.getElementById("nav_feight").value;   		
    		
    		if(nav_name==""){
    		document.getElementById("err_id").innerHTML="<span class='err'>请输入类别名称</span>";
    		judge =  false;
    		}	
    		if(nav_feight==""){
    		document.getElementById("err_name").innerHTML="<span class='err'>请输入权重</span>";
    		judge = false;
    		}  
    			
    		return judge;	
    	}
    </script>
  </head>
  
  <body>
   <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="left.jsp"></jsp:include>
   <div class="title">
 	<h2><a href="admin/navlist.jsp" class="back">查看类别</a>添加新闻类别 </h2>
  </div>
  
  
<hr>
 
    <form action="admin/insertnav" method="post">
    <table>
    	<tr>
    	<td> 新闻类别：</td>
    	<td> <input type="text" id="nav_name" name="nav_name" autocomplete="off" maxlength=50></input></td>
    	<td id="err_id"></td>
    	</tr>
    	<tr>
    	<td> 排序权重：</td>
    	<td> <input  type="text" id="nav_feight" name="nav_feight" autocomplete="off" maxlength=10></input></td>
    	<td id="err_name"></td>
    	</tr>
    	
    	<tr>
    	<td>
    	</td>
    	<td> <input type="submit" id="manager_submit" name="manager_submit" autocomplete="off" maxlength=50 value="提交" onclick="return dopost()"></input></td>
    	</tr>
    </table>
    </form>
   
  </body>
</html>

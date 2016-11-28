<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page123">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
	

 <script type="text/javascript">		
    	function dopost(){  	
    		var judge = true;
    		var user = document.getElementById("manager_id").value;    		
    		var name = document.getElementById("manager_name").value;
    		var pass = document.getElementById("manager_password").value;
    		var repass = document.getElementById("re_manager_password").value;   		
    		if(user==""||user.length<3){
    		document.getElementById("err_id").innerHTML="<span class='err'>登录账号至少三位</span>";
    		judge = false;
    		}  	
    		if(name==""){
    		document.getElementById("err_name").innerHTML="<span class='err'>请输入真实姓名</span>";
    		judge =  false;
    		}	
    		if(pass==""){
    		document.getElementById("err_paw").innerHTML="<span class='err'>请输入密码</span>";
    		judge = false;
    		}  
    		if(pass!=repass){
    		document.getElementById("err_repaw").innerHTML="<span class='err'>两次密码不一致</span>";
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
 	<h2><a href="admin/showManager.jsp" class="back">查看管理员</a>添加管理员 </h2>
  </div>
  
  
<hr>
 
    <form action="admin/insertManager" method="post">
    <table>
    	<tr>
    	<td> 登录账号：</td>
    	<td> <input type="text" id="manager_id" name="manager_id" autocomplete="off" maxlength=10></input></td>
    	<td id="err_id"></td>
    	</tr>
    	<tr>
    	<td> 真实姓名：</td>
    	<td> <input  type="text" id="manager_name" name="manager_name" autocomplete="off" maxlength=20></input></td>
    	<td id="err_name"></td>
    	</tr>
    	<tr>
    	<td> 登录密码：</td>
    	<td> <input type="password"  id="manager_password" name="manager_password" autocomplete="off" maxlength=50></input></td>
    	<td id="err_paw"></td>
    	</tr>
    	<tr>
    	<td> 确认密码：</td>
    	<td> <input type="password" id="re_manager_password" name="re_manager_password" autocomplete="off" maxlength=50></input></td>
    	<td id="err_repaw"></td>
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

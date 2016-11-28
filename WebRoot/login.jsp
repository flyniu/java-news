<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String msg = request.getParameter("msg")==null?"":"错误的用户名密码";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
  </head>
  
  <body>
  <div class="login-title">新闻发布系统后台<small>登录</small></div>
    <div class="login-box"></div>
    <div class="box">
    <div class="log">
    <h2>用户登录</h2>
    <form action="logservlet" method="post" id="form">
    	<p><label>账号：</label><input type="text" name="manager_id" id="manager_id"></p>
    	<p><label>密码：</label><input type="password" name="manager_pwd" id="manager_pwd"></p>
    	<a href="javascript:void(0)" class="btn" onclick="postform()">登录</a>
    	<p><span id="msg" class="msg"><%=msg %></span></p>
    </form>
    </div> 
    </div>
  	<div class="footer"><center><h5>7.20</h5></center></div>
  </body>
  <script type="text/javascript">
  function postform(){

 		var manager_id = document.getElementById("manager_id").value;
 		var manager_pwd = document.getElementById("manager_pwd").value;

 		if(manager_id== "" || manager_pwd==""){

 			document.getElementById("msg").innerHTML="请输入用户名或密码";
 			return;
 		}
 		else{
			 document.getElementById("form").submit();
 		}
 		 
  }
  
  </script>
</html>

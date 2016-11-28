<%@page import="com.entity.Artical"%>
<%@page import="com.entity.Nav"%>
<%@page import="com.handle.ActionBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ActionBean ac = new ActionBean();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>前台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/admin.css">

  </head>
  
  <body>

   	<jsp:include page="top.jsp"></jsp:include>
   	<jsp:include page="nav.jsp"></jsp:include>   	
   	<div class="index-main-box">
   	<% List<Nav> list2 = ac.querynavlist(); 
   		for(Nav nav:list2){
   		%>
   		<div class="pannel">
   		<div>
   		
   		
   			<h2><%=nav.getNav_name() %><a href="#" class="more" target="_blank">更多</a></h2>
   			<ul>
   				<% List<Artical> list = ac.queryarticalbytype(nav.getNav_id());for(Artical artical:list){ %>
   				<li><a href="" value="<%=artical.getArtical_id()%>"><%=artical.getArtical_title() %></a> <span><%=artical.getArtical_date() %></span></li>
   			<%} %>
   			
   				
   			</ul>
   		</div>
   		
   		</div>
   		<%} %>
   		
   		
   	</div>
   	<div class="footer1"><center><h5>7.20</h5></center></div>
  </body>
</html>

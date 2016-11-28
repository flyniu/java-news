<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="top-box">

	<div class="sys-logo">
		前台界面
	</div>
	<form action="search.html" method="get">
	<input type="text" name="search" placeholder="请输入关键词"/>
	<input type="submit"/ value="search">
	</form>
</div>

<%@page import="com.entity.Nav"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Nav> list = (List)request.getAttribute("navlist");
if(list==null) return;
%>
<div class="nav-box">
	<ul>
	
		<li><a href="#">首页</a></li>
		<%for(Nav nav:list){ %>
		<li><a href="newsList.html?nav_id<%=nav.getNav_id()%>"><%=nav.getNav_name() %></a></li>
		<%
		} %>
	</ul>
</div>
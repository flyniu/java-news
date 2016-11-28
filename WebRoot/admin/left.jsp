<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name ="";
HttpSession session1= request.getSession();
if(session1.getAttribute("name")!=null){
 	name = session1.getAttribute("name").toString();
}
%>

<div class="left">
	<div class="title">
	<h2>用户导航</h2>
	<hr>
	</div>
	<ul>
	<li class="welcome">welcome</li>
	<li class="welcome"><%=name %></li>
	<li><a href="admin/showManager.jsp">用户管理</a></li>
		<li><a href="admin/navlist.jsp">类别管理</a></li>
		<li><a href="admin/articallist.jsp">文章管理</a></li>
		<li><a href="admin/quit.jsp">退出登录</a></li>
	</ul>


</div>

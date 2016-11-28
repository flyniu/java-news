<%@page import="com.db.sqlHelper"%>
<%@ page language="java" import="java.util.*,com.entity.*,com.tools.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id = request.getParameter("manager_id");
String name = request.getParameter("nav_name");
String artical_id = request.getParameter("artical_id");
if(id!=null){
		Manager manager = new Manager();
		manager.setManager_id(fonts.convertToutf8(id));
		sqlHelper sql = new sqlHelper();
		if(sql.delete(manager)){
			sql.destroy();
			response.sendRedirect("showManager.jsp");
			return;
		}
		}
if(name!=null){
	Nav nav = new Nav();
	nav.setNav_name(fonts.convertToutf8(name));
	sqlHelper sql = new sqlHelper();
	if(sql.deletenav(nav)){
		sql.destroy();
		response.sendRedirect("navlist.jsp");
	}
}
if(artical_id!=null){
	
	Artical artical = new Artical();
	artical.setArtical_id(artical_id);
	sqlHelper sql = new sqlHelper();
	if(sql.deleteartical(artical)){
	sql.destroy();
	response.sendRedirect("articallist.jsp");
	}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'del.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  </body>
</html>

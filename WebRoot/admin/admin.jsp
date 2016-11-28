<%@page import="com.handle.ActionBean"%>
<%@page import="com.db.sqlHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">

  </head>
  
  <body>
  <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="left.jsp"></jsp:include>
  <div class="content">
  <h1 align="center">welcome </h1>
 </div>

 <script type="text/javascript">
 
 	function delete1(){
 	var check = document.getElementsByName("rdo");
 	var obj=null;
 		for(var i=0;i<check.length;i++){			
 				if(check[i].checked){
 				obj = check[i];				
 				break;
 				}
 			}
 			if(obj==null){
 			alert("没有选中，请选择一行在操作");
 			return;
 		}else{
 		if(confirm("确定删除？")){
 			location="del.jsp?manager_id="+obj.value;
 			}
 		}
 	}
 	function update(){
 		var check = document.getElementsByName("rdo");			
 		var obj =null;	
 			for(var i=0;i<check.length;i++){			
 				if(check[i].checked){
 				obj = check[i];				
 				break;
 				}
 			}
 		
 		if(obj==null){
 			alert("没有选中，请选择一行在操作");
 			return;
 		}else{
 			location="edit.jsp?manager_id="+obj.value;
 		}
 	}
 
 </script>
  </body>
</html>

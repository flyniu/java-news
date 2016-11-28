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
  <div class="title">
   <h2 align="center">管理员列表</h2>
  <hr>
  </div>
  
 <table class="tab" cellspacing="0" align="center">
 <tr><td>选择</td><td class="text-center">序号</td><td>登录账号</td><td>真实姓名</td>
 </tr>
 <%
			ActionBean action = new ActionBean();
			out.println(action.queryManager());
  %>
 <tr><td colspan="4" style="border-bottom:0"><a class="btn" href="admin/addManager.jsp">
 	添加管理员
 </a>
 <a class="btn"   href="javascript:void(0)" id="update" onclick="update()">修改</a>
  <a class="btn"   href="javascript:void(0)" id="update" onclick="delete1()">删除</a>
 </td></tr>
 </table> 
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

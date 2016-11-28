<%@page import="com.tools.fonts"%>
<%@page import="com.handle.ActionBean"%>
<%@page import="com.db.sqlHelper"%>
<%@ page language="java" import="java.util.*,com.entity.Nav" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String nav_id=request.getParameter("nav_id");
String artical_title = fonts.convertToutf8(request.getParameter("artical_title"));
String page1 = request.getParameter("page");
ActionBean ac = new ActionBean();
List<Map<String,String>> list =ac.queryallartical(nav_id,artical_title);
List<Nav> list3 = ac.querynavlist();
int totalnum = list.size();
int totalpage = totalnum%10==0? totalnum/10:totalnum/10+1;
int pagenum=0;
if(page1==null){
pagenum=1;
}else{
	pagenum = Integer.parseInt(page1);
}
List<Map<String,String>> list2 =ac.querylimitartical(pagenum,nav_id,artical_title);

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
   <h2 align="center">新闻列表</h2>
  <hr>
  </div>
  
 <table class="tab" cellspacing="0" align="center">
 <tr>
 <td colspan="5" >
 <form method="post" action="admin/articallist.jsp">
 	<label>
 	新闻类别 
 	</label>
 	
 	<select name="nav_id">
 	<option value="">==请选择新闻类别==</option>
 	<%for(Nav nav2 :list3){ %>
 	<option  <%=nav2.getNav_id().equals(nav_id)? "selected='selected'": "" %>value="<%=nav2.getNav_id() %>"><%=nav2.getNav_name() %>
 	</option>
 	<%} %>
 	</select>
	<label>标题:</label>
	<input type="text" name="artical_title" id="artical_title" value="<%= artical_title==null? "" : artical_title %>"/>
	<input type="submit" name="submit" value="搜索"/>
	</form>
 </td>
 </tr>
 <tr><td  class="text-center10">选择</td><td  class="text-center10">序号</td><td class="text-center20">新闻名称</td><td class="text-center20">新闻类别</td><td class="text-center20">发布时间</td>
 </tr>
 <%   int i=0;for(Map map: list2){ %>
 <tr><td class="text-center1"><input type="radio" name="rdo" value=<%=map.get("artical_id") %> autocomplete="off"></input></td><td  class="text-center1"><%=++i %></td><td class="text-center2"><%=map.get("artical_title") %></td><td class="text-center2"><%=map.get("nav_name") %></td><td class="text-center2"><%=map.get("artical_date") %></td>
 </tr>
 
 <%} %>
  <tr><td colspan="5" class="text-center5">
    <span>总共条<%=totalnum %>记录   共<%=totalpage %>页</span><%if(pagenum!=1){ %><a href="admin/articallist.jsp?page=1<%=nav_id==""||nav_id==null?"":"&nav_id="+nav_id%><%=artical_title==null?"":"&artical_title="+artical_title%>">首页</a><a href="admin/articallist.jsp?page=<%=pagenum-1%><%=nav_id==""||nav_id==null?"":"&nav_id="+nav_id%><%=artical_title==null?"":"&artical_title="+artical_title%>">上一页</a> <%} %><%if(pagenum!=totalpage){ %><a href="admin/articallist.jsp?page=<%=pagenum+1%><%=nav_id==""||nav_id==null?"":"&nav_id="+nav_id%><%=artical_title==null?"":"&artical_title="+artical_title%>">下一页</a><a href="admin/articallist.jsp?page=<%=totalpage %><%=nav_id==""||nav_id==null?"":"&nav_id="+nav_id%><%=artical_title==null?"":"&artical_title="+artical_title%>">末页</a><%} %><span>当前第<%=pagenum %>页</span>
	<span>跳转至
	<select class="text-right" onchange="location='articallist.jsp?page='+this.value+'<%=nav_id==""||nav_id==null?"":"&nav_id="+nav_id%>'+'<%=artical_title==null?"":"&artical_title="+artical_title%>'">
	<%for(int j=0;j<totalpage;j++){ %>
	<option value="<%=j+1%>" <%=pagenum==j+1? "selected='selected'":"" %>><%=j+1%></option>
	<%
	} %>
	</select>
	页</span>
	</td> </tr>
 <tr><td colspan="4" style="border-bottom:0"><a class="btn" href="admin/addartical.jsp">
 	添加类别
 </a>
 <a class="btn"   href="javascript:void(0)" id="update" onclick="updatenews()">修改</a>
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
 			location="del.jsp?artical_id="+obj.value;
 			}
 		}
 	}
 	function updatenews(){
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
 			location="editartical.jsp?artical_id="+obj.value;
 		}
 	}
 
 </script>
  </body>
</html>

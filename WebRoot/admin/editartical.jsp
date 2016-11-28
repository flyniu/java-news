<%@page import="com.tools.fonts"%>
<%@page import="com.handle.ActionBean"%>
<%@ page language="java" import="java.util.*,com.entity.*;" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ActionBean ac = new ActionBean();
String artical_id = request.getParameter("artical_id");
Map map = ac.quertArtical4edit(artical_id);
List<Nav> list = (List)map.get("navlist");

Artical artical = (Artical)map.get("artical");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改新闻</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page123">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css">
	<link rel="stylesheet" href="../themes/default/default.css" />
	<link rel="stylesheet" href="admin/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="admin/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="admin/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="admin/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="admin/kindeditor/plugins/code/prettify.js"></script>	
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : 'admin/kindeditor/plugins/code/prettify.css',
				uploadJson : 'admin/upload_json.jsp',
				fileManagerJson : 'admin/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
 <script type="text/javascript">		
    	function dopost(){  	
    		var judge = true;
    		var artical_name = document.getElementById("artical_name").value;    		
    		var artical_date = document.getElementById("artical_date").value;   		
    		var nav_name = document.getElementById("nav_name").value;
    		if(artical_name==""){
    		document.getElementById("err_id").innerHTML="<span class='err'>请输入新闻名称</span>";
    		judge =  false;
    		}	
    		if(nav_name==""){
 		    document.getElementById("err_select").innerHTML="<span class='err'>请输入类别名称</span>";
 			judge =  false; 		
    		}
    		if(artical_date==""){
    		document.getElementById("err_name").innerHTML="<span class='err'>请输入时间</span>";
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
 	<h2 >添加新闻 </h2>
  </div>
  
  
<hr>
 
    <form action="admin/editartical" method="post" name="frm">
    <table>
    <input type="hidden" value="<%=artical_id%>" name="artical_id" id="artical_id">
    	<tr>
    	<td> 新闻名称：</td>
    	<td> <input value=<%=artical.getArtical_title() %> class="radius"  type="text" id="artical_name" name="artical_name" autocomplete="off" maxlength=50></input></td>
    	<td id="err_id"></td>
    	</tr>
    	
    	<tr>
    	<td> 新闻类别：</td>
    	<td>
    	<select name="nav_name" id="nav_name">
    	<option value="">==新闻种类选择==  		
    	</option>
   			<%
   			
   			for(Nav nav:list) {
   	
   			%>
   			<option <%=nav.getNav_id().equals(artical.getNav_id())? "selected='selected'":"" %> value="<%=nav.getNav_id()%>"><%=nav.getNav_name()%></option>
   			<%} %>
    	</select>
    	</td>
    	<td id="err_select"></td>
    	</tr>
    	<tr>
    	<td> 发布日期：</td>
    	<td> <input type="text"  id="artical_date" name="artical_date" onclick="WdatePicker()" value="<%=artical.getArtical_date() %>"></input></td>
    	<td id="err_name"></td>
    	</tr>
    	<tr>
    	<td valign="top"> 新闻正文：</td>
    	<td> <textarea name="content1" style="width:900px;height:300px;"> <%=fonts.htmlspecialchars(artical.getArtical_content()) %></textarea></td>
    	<td id="err_name"></td>
    	</tr>
    	<tr>
    	<td>
    	</td>
    	<td> <input type="submit" id="manager_submit" name="manager_submit" autocomplete="off" maxlength=50 value="提交" onclick="return dopost()"></input></td>
    	</tr>
    </table>
    </form>
   
  </body>
  <script language="javascript" type="text/javascript" src="admin/js/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript" src="admin/js/calendar.js"></script>
</html>

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.sqlHelper;
import com.entity.Manager;
import com.tools.fonts;

public class insertManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public insertManager() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String manager_id = request.getParameter("manager_id");
		String manager_name= request.getParameter("manager_name");
		String manager_password = request.getParameter("manager_password");
	
		Manager manager = new Manager();
		manager.setManager_id(fonts.convertToutf8(manager_id));
		
		manager.setManager_name(fonts.convertToutf8(manager_name));
	
		manager.setManager_password(manager_password);
		sqlHelper sql = new sqlHelper();
		if(sql.uniq(manager_id)){
		response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");		
			out.println("  <BODY>");
			out.println("用户名已存在");	out.println("<a href='addManager.jsp'>返回重新输入</a>");
			out.println("  </BODY>");
			out.println("</HTML>");
		
			out.flush();
			out.close();
		}else{String b = sql.insertmanager(manager);	
		sql.destroy();
		response.sendRedirect("showManager.jsp");
			
		}
			
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

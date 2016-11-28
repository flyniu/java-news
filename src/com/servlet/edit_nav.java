package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.sqlHelper;
import com.entity.Nav;
import com.tools.fonts;

public class edit_nav extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public edit_nav() {
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
		String nav_name = request.getParameter("nav_name");
		String nav_feight_strString = request.getParameter("nav_feight");
		String nav_id = request.getParameter("nav_id");
		int nav_feight=0;
		boolean judge = true;
		try {
			nav_feight = Integer.parseInt(nav_feight_strString);
		} catch (NumberFormatException e) {		
			judge =false;
			e.printStackTrace();
		}
		if(judge){
		Nav nav = new Nav();	
		nav.setNav_id(nav_id);
		nav.setNav_feight(nav_feight);
		nav.setNav_name(fonts.convertToutf8(nav_name));
		sqlHelper sql = new sqlHelper();
		boolean b = sql.updatenav(nav);	
		sql.destroy();	
		if(b){
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("navlist.jsp");
		}else{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<script type='text/javascript'>" +
					"alert('输入有误请重新输入')"
					+" location = 'navlist.jsp'"+							
					"</script>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}
		else{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>loading...</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<script type='text/javascript'>" +
					"alert('输入有误请重新输入');"
					+" location = 'editnav.jsp';"+							
					"</script>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
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

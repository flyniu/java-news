package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.sqlHelper;
import com.entity.Artical;
import com.tools.fonts;

public class editartical extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public editartical() {
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
		String artical_id = request.getParameter("artical_id");
		String artical_title = request.getParameter("artical_name");
		String artical_date = request.getParameter("artical_date");
		String artical_content = request.getParameter("content1");
		String nav_id = request.getParameter("nav_name");
		Artical artical = new Artical();
		artical.setArtical_title(fonts.convertToutf8(artical_title));
		artical.setArtical_date(artical_date);
		artical.setNav_id(nav_id);
		artical.setArtical_content(fonts.convertToutf8(artical_content));
		artical.setArtical_id(artical_id);
		sqlHelper sql = new sqlHelper();
		boolean judge = sql.editartical(artical);
		sql.destroy();
		
		if(judge==false){			
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("插入失败");	out.println("<a href='editartical.jsp?artical_id="+ artical_id +"'>返回重新输入</a>");
			out.println("  </BODY>");
			out.println("</HTML>");

			out.flush();
			out.close();
		}
		if(judge==true){
			response.sendRedirect("articallist.jsp");
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

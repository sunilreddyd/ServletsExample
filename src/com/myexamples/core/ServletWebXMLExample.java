package com.myexamples.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletWebXMLExample
 */
public class ServletWebXMLExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String param1 = getServletConfig().getInitParameter("InitParamName1");
		String param2 = getServletConfig().getInitParameter("InitParamName2");
		getServletContext().setAttribute("InitParamName1", param1);
		getServletContext().setAttribute("InitParamName2", param2);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//RESPONSE Object
		PrintWriter out = response.getWriter();
		out.println("<b>This is my First Web XML Page</b><br>");
		out.println("<b>ServletContext + ServletConfig Attribute-->InitParamName1: "+getServletContext().getAttribute("InitParamName1")+"</b><br>");
		out.println("<b>ServletContext + ServletConfig Attribute-->InitParamName2: "+getServletContext().getAttribute("InitParamName2")+"</b><br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

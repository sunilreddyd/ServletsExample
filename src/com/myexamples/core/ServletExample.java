package com.myexamples.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet(description="This is my Sample Servlet", urlPatterns={"/ServletExample_0001","/ServletExample_0002"},
initParams={@WebInitParam(name="InitParamName", value="Sunil Kumar Duvvuru")})
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String name = getServletConfig().getInitParameter("InitParamName");
		getServletContext().setAttribute("ParamName", name);
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//RESPONSE Object
		PrintWriter out = response.getWriter();
		out.println("<b>This is my First Page</b><br>");
		
		//REQUEST Parameters
		String name = request.getParameter("UserName");
		out.println("<b>My First Request Parameter-->Name: "+name+"</b><br>");
		
		//SESSION Attributes
		HttpSession session = request.getSession();
		if(name!=null && !name.isEmpty()){
			session.setAttribute("SessionName", name);
		}
		out.println("<b>My First Session Attribute-->Name: "+session.getAttribute("SessionName")+"</b><br>");
	
		//Context Attributes
		ServletContext context = request.getServletContext();
		if(name!=null && !name.isEmpty()){
			context.setAttribute("ServletContextName", name);
		}
		out.println("<b>My First ServletContext Attribute-->Name: "+context.getAttribute("ServletContextName")+"</b><br>");
		out.println("<b>My First ServletContext + ServletConfig Attribute-->Name: "+context.getAttribute("ParamName")+"</b><br>");
	
		//INIT Parameters
		out.println("<b>My First Init Parameter-->Name: "+getServletConfig().getInitParameter("InitParamName")+"</b><br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Send Error to Pages
		response.sendError(404,"!Do Post is not defined for this Servlet");

	}

}

package com.myexamples.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPOSTExample
 */
@WebServlet(description="This is my Post Example", urlPatterns={"/MyPOSTExample"})
public class MyPOSTExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<br>My POST Page<br>");
		out.println("<br>Full Name-->"+request.getParameter("firstName")+"&nbsp;&nbsp;"+request.getParameter("lastName"));
		out.println("<br>You are-->"+request.getParameter("gender"));
		String[] graduation = request.getParameterValues("graduation");
		for(String grade: graduation){
			out.println("<br>Studied-->"+grade);
		}
		String[] vehicles = request.getParameterValues("vehicle");
		for(String vehicle: vehicles){
			out.println("<br>You have -->"+vehicle);
		}
		
	}

}

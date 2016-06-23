<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is JSP Example</title>
</head>
<body>

<%!
	int k = 10;
	int n = 15;
%>

<%!
	public int add(int a, int b){
		
		return a+b;
	}
%>

Today's Date is : <%=new Date() %><br><br><br>
Sum of <%=k %> and <%=n %> is: <%=add(k,n) %>
	
<%-- This is JSP comment --%>
<br><br><br>

This is my POST page for JSP<br>
Full Name--><%=request.getParameter("firstName")%> and <%=request.getParameter("lastName") %><br>
You are--><%=request.getParameter("gender") %><br>

<%
	String[] graduation = request.getParameterValues("graduation");
	for(String grade: graduation){
%>
Studied--><%=grade%><br>
<%
	}
%>

<%
	String[] vehicles = request.getParameterValues("vehicle");
	for(String vehicle: vehicles){
%>
<br>You have --><%=vehicle %>
<%
	}
%>

<%

pageContext.getAttribute("Name", pageContext.APPLICATION_SCOPE);

%>


</body>
</html>
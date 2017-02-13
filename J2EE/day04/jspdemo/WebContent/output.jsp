<%@page import="pkg.CapBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--
	<%
		CapBean cb = new CapBean();
		cb.setName(request.getParameter("uname"));
		cb.convert();
	%>
	Name : <%= cb.getName() %> <br/>
	Caps : <%= cb.getCapName() %> <br/>
--%>
	<h2>output.jsp</h2>
	<jsp:useBean id="cb" class="pkg.CapBean" scope="application"/>
	<jsp:setProperty name="cb" property="name" param="uname"/>
	<% cb.convert(); %>
	Name : <jsp:getProperty name="cb" property="name"/> <br/>
	Caps : <jsp:getProperty name="cb" property="capName"/> <br/>
	
	<jsp:forward page="output2.jsp"/>
</body>
</html>





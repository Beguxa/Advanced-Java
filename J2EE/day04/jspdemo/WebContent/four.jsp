<%@page import="java.util.List"%>
<%@page import="dac.bookshop.daos.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%!
		BookDao dao = new BookDao();
		public void jspInit() {
			try {
				dao.open();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		public void jspDestroy() {
			dao.close();
		}
	%>
	
	<form method="post" action="">
	<% 
		List<String> list = dao.getSubjectList();
		for(String subject:list) { 
	%>
		<input type="radio" name="subject" value="<%= subject %>"/> <%= subject %>
		<br/>
	<% } %>
	<input type="submit" value="Show Books"/>
	</form>
</body>
</html>

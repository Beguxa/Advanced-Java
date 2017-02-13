package com.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dac.bookshop.daos.BookDao;

public class SubjectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		String user = "anonymous";
		Cookie[] arrCookie = req.getCookies();
		if(arrCookie!=null) {
			for (Cookie c : arrCookie) {
				if(c.getName().equals("user")) {
					user = c.getValue();
					break;
				}
			}
		}
		out.printf("Hello, %s<hr>\r\n", user);
		out.println("<form method='get' action='books'>");
		BookDao dao = new BookDao();
		try {
			dao.open();
			List<String> list = dao.getSubjectList();
			for (String sub : list) {
				out.printf("<input type='radio' name='subject' value='%s'/>%s<br/>\r\n", sub, sub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		out.println("<a href='showcart'>Show Cart</a>");
		out.println("<input type='submit' value='Show Books'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}

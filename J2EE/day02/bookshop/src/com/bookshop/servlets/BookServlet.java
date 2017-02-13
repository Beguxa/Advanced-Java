package com.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.pojos.Book;

import dac.bookshop.daos.BookDao;

public class BookServlet extends HttpServlet {
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
		Cookie[] arrCookie = req.getCookies();
		String user = "";
		for (Cookie c : arrCookie) {
			if(c.getName().equals("user")) {
				user = c.getValue();
				break;
			}
		}
		out.printf("Hello, %s<hr>\r\n", user);
		out.println("<form method='post' action='addcart'>");
		String subject = req.getParameter("subject");
		out.printf("<h3>Books of '%s'</h3><br/>\r\n", subject);
		BookDao dao = new BookDao();
		try {
			dao.open();
			List<Book> list = dao.getBooks(subject);
			for (Book b : list) {
				out.printf("<input type='checkbox' name='book' value='%d'/>%s<br/>\r\n", b.getId(), b.getName());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			dao.close();
		}
		out.println("<input type='submit' value='Add To Cart'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}


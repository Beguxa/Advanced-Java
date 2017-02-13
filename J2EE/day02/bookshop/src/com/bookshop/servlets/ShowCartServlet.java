package com.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCartServlet extends HttpServlet {
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
		HttpSession session = req.getSession();
		ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
		out.println("<table>");
		for (int id : cart) {
			out.println("<tr>");
			out.printf("<td>%d</td>\r\n", id);
			out.printf("<td>Name</td>\r\n");
			out.printf("<td>Author</td>\r\n");
			out.printf("<td>Subject</td>\r\n");
			out.printf("<td>Price</td>\r\n");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}

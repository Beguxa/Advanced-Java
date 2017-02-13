package com.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		if(user.equals("anonymous")) {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			return;
		} 
		// if user is alreay logged in.
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Thank you for purchasing.<br/><br/>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}

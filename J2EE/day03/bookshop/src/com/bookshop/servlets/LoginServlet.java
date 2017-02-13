package com.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.pojos.Login;

import dac.bookshop.daos.LoginDao;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		LoginDao dao = new LoginDao();
		try {
			dao.open();
			Login lg = dao.findLogin(user);
			boolean success = pass.equals(lg.getPass());
			if(success) {
				/*
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Welcome, user.</h3><br/><br/>");
				out.println("</body>");
				out.println("</html>");
				*/
				
				Cookie c = new Cookie("user", user);
				//c.setMaxAge(3600); //seconds
				resp.addCookie(c);
				
				//// moved into HttpSessionListener
				//HttpSession session = req.getSession();
				//session.setAttribute("cart", new ArrayList<Integer>());
				
				// go to the SubjectServlet i.e. /subjects
				////way1: http redirection
				resp.sendRedirect("subjects");
				//resp.sendRedirect(resp.encodeRedirectURL("subjects"));
				////way2: request forwarding
				//RequestDispatcher rd = req.getRequestDispatcher("subjects");
				//rd.forward(req, resp);
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Invalid Username or Password.</h3><br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
	}
}







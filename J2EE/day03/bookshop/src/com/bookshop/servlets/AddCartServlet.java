package com.bookshop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
		
		String[] arrId = req.getParameterValues("book");
		for (String strId : arrId) {
			int id = Integer.parseInt(strId);
			cart.add(id);
		}
		RequestDispatcher rd = req.getRequestDispatcher("subjects");
		rd.forward(req, resp);
	}
}

package com.bookshop.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dac.bookshop.daos.Dao;

public class ConfigServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Dao.DB_DRIVER = config.getInitParameter("DB_DRIVER");
		Dao.DB_URL = config.getInitParameter("DB_URL");
		Dao.DB_USER = config.getInitParameter("DB_USER");
		Dao.DB_PASS = config.getInitParameter("DB_PASS");
		
		System.out.println("Config Servlet is Loaded.");
		
		try {
			Class.forName(Dao.DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}

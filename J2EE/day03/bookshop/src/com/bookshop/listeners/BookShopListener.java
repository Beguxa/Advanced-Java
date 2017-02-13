package com.bookshop.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class BookShopListener implements HttpSessionListener, ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent cse) {
		System.out.println("WebApplication Started.");
	}
	@Override
	public void contextDestroyed(ServletContextEvent cse) {
		System.out.println("WebApplication Destroyed");
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("New HttpSession Created.");
		HttpSession session = se.getSession();
		session.setAttribute("cart", new ArrayList<Integer>());
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("New HttpSession Destroyed.");
	}
}

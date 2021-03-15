package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tiger")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (int i = 0; i < 5; ++i) {
			out.println("Hello World");
			out.println("안녕 안녕");
		}
		
		resp.setCharacterEncoding("UTF-8");
		for (int i = 0; i < 5; ++i) {
			out.println("Hello World");
			out.println("안녕 안녕");
		}
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println("I'm shock. 야항");
	}
}

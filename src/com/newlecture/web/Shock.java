package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/do-notice")
public class Shock extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title"); 
		String content = req.getParameter("content"); 
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset:UTF-8;");
		PrintWriter out = resp.getWriter();
		
		out.println(title);
		out.println(content);
		out.close();
	}
}

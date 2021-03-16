package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addNum")
public class AddNumber implements Servlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		int result = Integer.parseInt(arg0.getParameter("num1")) + Integer.parseInt(arg0.getParameter("num2"));
		String num1_ = arg0.getParameter("num1");
		String num2_ = arg0.getParameter("num2");
		
		
		
		
		PrintWriter out = arg1.getWriter();
		out.printf("결과는 땡땡입니다.: %d", result);
		out.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

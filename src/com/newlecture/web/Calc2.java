package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		int result = 0;
		
		int v = 0;
		if (!v_.equals("")) v = Integer.parseInt(v_);
		
		if ("=".equals(op)) {
//			int x = (Integer) session.getAttribute("value");
//			int y = v;
//			String operator = (String) session.getAttribute("op");
			int x = 0;
			int y = 0;
			String operator = "";
			for (Cookie cookie : cookies) {
				if ("value".equals(cookie.getName())) {
					x = Integer.parseInt(cookie.getValue());
				}
				if ("op".equals(cookie.getName())) {
					operator = cookie.getValue();
				}
			}
			
			switch (operator) {
			case "+":
				result = x + y;
				break;
			case "-":
				result = x - y;
				break;
			default:
				break;
			}
			res.getWriter().println(result);
		} else {
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			res.addCookie(valueCookie);
			res.addCookie(opCookie);
		}
	}
}

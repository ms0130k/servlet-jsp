package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tiger")
public class Nana extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 
		int cnt;
		try {
			cnt = Integer.parseInt(request.getParameter("cnt"));
		} catch (NumberFormatException e) {
			cnt = 0;
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		if (cnt > 0) {
			for (int i = 0; i < cnt; i++) {
				out.println(i + ": 안녕");
			}
		} else {
			out.println("0이에요");
		}
		
		out.close();
	}
}

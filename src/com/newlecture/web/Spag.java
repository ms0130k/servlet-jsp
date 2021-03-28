package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num_ = req.getParameter("num");
		System.out.println(">>" + num_);
		RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
		req.setAttribute("key", "value");
		dispatcher.forward(req, resp);
	}
}

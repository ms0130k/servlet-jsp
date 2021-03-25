package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String result = "0";
		String prevValue = "";
		String prevOperator = "";
		String currentValue = isNotBlank(req.getParameter("value")) ? req.getParameter("value") : "";
		String currentOperator = isNotBlank(req.getParameter("operator")) ? req.getParameter("operator") : "";
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("result".equals(cookie.getName())) {
					result = cookie.getValue() + currentValue + currentOperator;
				}
				if ("value".equals(cookie.getName())) {
					prevValue = cookie.getValue();
				}
				if ("operator".equals(cookie.getName())) {
					prevOperator = cookie.getValue();
				}
			}
		}
		if (isNotBlank(currentValue) && isNotBlank(prevOperator)) {
			int x = Integer.parseInt(prevValue);
			int y = Integer.parseInt(currentValue);
			switch (prevOperator) {
			case "+":
				currentValue = String.valueOf(x + y);
				break;
			case "-":
				currentValue = String.valueOf(x - y);
				break;
			case "X":
				currentValue = String.valueOf(x * y);
				break;
			case "÷":
				currentValue = String.valueOf(x / y);
				break;
			case ".":
				//모르겠는데? .바로 다음에 한번은 붙일 수 있어. 3.1에서 3.14는 어떻게 만들어?
				break;
			default:
				System.out.println("error");
			}
		} else {
			currentValue = isNotBlank(prevValue) ? prevValue : currentValue;
		}
		if ("=".equals(currentOperator)) {
			result = prevValue;
		}
		if ("CE".equals(currentOperator)) {
			initCookie(res);
			writePage(res, "0");
			return;
		}
		setCookie(res, currentValue, currentOperator, result);
		writePage(res, result);
	}
	
	private void setCookie(HttpServletResponse res, String value, String operator, String result) {
		Cookie prevValue = new Cookie("value", value);
		Cookie prevOperator = new Cookie("operator", operator);
		Cookie prevResult = new Cookie("result", result);
		res.addCookie(prevValue);
		res.addCookie(prevOperator);
		res.addCookie(prevResult);
	}
	
	private void initCookie(HttpServletResponse res) {
		Cookie prevValue = new Cookie("value", "");
		Cookie prevOperator = new Cookie("operator", "");
		Cookie prevResult = new Cookie("result", "");
		res.addCookie(prevValue);
		res.addCookie(prevOperator);
		res.addCookie(prevResult);
	}
	
	private void writePage(HttpServletResponse res, String result) throws IOException {
		PrintWriter out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input {");
		out.write("	width:50px;");
		out.write("	height:50px;");
		out.write("}");
		out.write(".output {");
		out.write("	height: 50px;");
		out.write("	background: #e9e9e9;");
		out.write("	font-size:24px;");
		out.write("	font-weight:bold;");
		out.write("	text-align:right;");
		out.write("	padding:0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"/calcpage\" method=\"post\">");
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td class=\"output\" colspan=\"4\">%s</td>", result);
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"÷\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"X\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
		out.write("				<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("		<div>");
		out.write("			결과: 0");
		out.write("		</div>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	private boolean isNotBlank(String str) {
		return str != null && !str.trim().equals("") ? true : false;
	}
}

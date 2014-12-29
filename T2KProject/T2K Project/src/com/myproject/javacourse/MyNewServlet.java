package com.myproject.javacourse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyNewServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html");
				
		double radius = 50;
		double circleArea;
		double hypotenuse = 50;
		double angleB = 30;
		double opposite;
		int base = 20;
		int exp = 13;
		double pow;
		String resultStr;
		
		circleArea = Math.PI * Math.pow(radius, 2);
		opposite = ((Math.sin(Math.toRadians(30))))* hypotenuse;
		pow = Math.pow(base,  exp);
		
		
		String line1 = new String("calculation 1: Area of circle with radius " +radius +" is "+ circleArea);
		String line2 = new String("calculation 2: Length of opposite where angle B " + angleB +	" is "+ opposite);
		String line3 = new String("calculation 3: Power of "+ base + " with exp of " +exp+" is " + pow);
		resp.getWriter().println("<br>");
		resultStr = line1 + "<br>" + line2  + "<br>" + line3 + " <br>";
		resp.getWriter().println(resultStr);
		
		
	}
}

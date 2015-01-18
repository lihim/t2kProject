package com.myproject.javacourse;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StockDetailsServlet  extends HttpServlet{

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		

	
		Stock PIH = new Stock("PIH", 13.1f, 12.4f, 2014, 11, 15);
		Stock AAL = new Stock("AAL", 5.78f, 5.5f, 2014, 11, 15);
		Stock CAAS = new Stock("CAAS", 32.2f, 31.5f, 2014, 11, 15);
		String resultStr;
		
		resultStr = PIH.getHtmlDescription() + "<br>" + AAL.getHtmlDescription() + "<br>" + CAAS.getHtmlDescription();
		
		resp.getWriter().println(resultStr);
	
	}
	
	
	
}

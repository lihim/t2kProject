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
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.NOVEMBER, 15);
	
		
		Stock PIH = new Stock("PIH", 13.1, 12.4, calendar.getTime());
		Stock AAL = new Stock("AAL", 5.78, 5.5, calendar.getTime());
		Stock CAAS = new Stock("CAAS", 32.2, 31.5, calendar.getTime());
		String resultStr;
		
		resultStr = PIH.getHtmlDescription() + "<br>" + AAL.getHtmlDescription() + "<br>" + CAAS.getHtmlDescription();
		
		resp.getWriter().println(resultStr);
	
	}
	
	
	
}

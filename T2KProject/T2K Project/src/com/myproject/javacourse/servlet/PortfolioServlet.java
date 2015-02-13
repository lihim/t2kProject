package com.myproject.javacourse.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myprojec.javacourse.service.PortfolioManager;
import com.myproject.javacourse.model.Portfolio;
import com.myproject.javacourse.model.Stock;

public class PortfolioServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html");

		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();

		resp.getWriter().println(portfolio);
				

		
		
		
		
		

		
	}
}

package com.myproject.javacourse.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myprojec.javacourse.service.PortfolioManager;
import com.myproject.javacourse.model.Portfolio;

public class PortfolioServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		resp.setContentType("text/html");

		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio1 = portfolioManager.getPortfolio();
				
		Portfolio portfolio2 = new Portfolio(portfolio1);
		portfolio2.settitle("Portfolio #2");
		
		//resp.getWriter().println("Potfolio 1: <br>");
		resp.getWriter().println(portfolio1.getHtmlString());
		//resp.getWriter().println("Potfolio 2: <br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");
		
		portfolio1.removeStock(0);
		
		//resp.getWriter().println("Potfolio 1: <br>");
		resp.getWriter().println(portfolio1.getHtmlString());
		//resp.getWriter().println("Potfolio 2: <br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");
		
		portfolio2.getStock(2).set_bid(55.55f);
		
		//resp.getWriter().println("Potfolio 1: <br>");
		resp.getWriter().println(portfolio1.getHtmlString());
		//resp.getWriter().println("Potfolio 2: <br>");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println("<br>");
		
		
		
		
		

		
	}
}

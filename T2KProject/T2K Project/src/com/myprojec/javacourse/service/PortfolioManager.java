package com.myprojec.javacourse.service;

import java.util.Calendar;

import com.myproject.javacourse.model.Portfolio;
import com.myproject.javacourse.model.Stock;

public class PortfolioManager {

	private Portfolio _portfolio;


	
	public PortfolioManager(){
		_portfolio = new Portfolio("Portfolio #1");

	}
	
	public Portfolio getPortfolio(){


		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.NOVEMBER, 15);

		
		_portfolio.addStock(new Stock("PIH", 13.1f, 12.4f, calendar.getTime()));
		_portfolio.addStock(new Stock("AAL", 5.78f, 5.5f, calendar.getTime()));
		_portfolio.addStock(new Stock("CAAS", 32.2f, 31.5f, calendar.getTime()));
		
		return _portfolio;
		
		
	}
}

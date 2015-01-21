package com.myprojec.javacourse.service;

import java.util.Calendar;

import com.myproject.javacourse.Stock;
import com.myproject.javacourse.model.Portfolio;

public class PortfolioManager {

	private Portfolio _portfolio;

	
	
	public PortfolioManager(){
		_portfolio = new Portfolio("lihi's protfolio");

	}
	
	public Portfolio getPortfolio(){


		int year = 2014;
		int mounth = 11;
		int day = 15;
		
		_portfolio.addStock(new Stock("PIH", 13.1f, 12.4f, year, mounth, day));
		_portfolio.addStock(new Stock("AAL", 5.78f, 5.5f, year, mounth, day));
		_portfolio.addStock(new Stock("CAAS", 32.2f, 31.5f, year, mounth, day));
		
		return _portfolio;
		
		
	}
}

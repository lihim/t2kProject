package com.myprojec.javacourse.service;

import java.util.Calendar;

import com.myproject.javacourse.Stock;
import com.myproject.javacourse.model.Portfolio;

public class PortfolioManager {

	private Portfolio portfolio;

	
	public PortfolioManager(){
		portfolio = new Portfolio("lihi's protfolio");

	}
	
	public Portfolio getPortfolio(){


		int year = 2014;
		int mounth = 11;
		int day = 15;
		
		portfolio.addStock(new Stock("PIH", 13.1f, 12.4f, year, mounth, day));
		portfolio.addStock(new Stock("AAL", 5.78f, 5.5f, year, mounth, day));
		portfolio.addStock(new Stock("CAAS", 32.2f, 31.5f, year, mounth, day));
		
		return portfolio;
		
		
	}
}

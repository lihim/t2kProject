package com.myprojec.javacourse.service;

import java.util.Calendar;

import com.myproject.javacourse.Stock;
import com.myproject.javacourse.model.Portfolio;

public class PortfolioManager {

	private Portfolio portfolio;
	
	public PortfolioManager(){
		portfolio = new Portfolio();
	}
	
	public Portfolio getPortfolio(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.NOVEMBER, 15);
		
		Stock PIH = new Stock("PIH", 13.1f, 12.4f, calendar.getTime());
		Stock AAL = new Stock("AAL", 5.78f, 5.5f, calendar.getTime());
		Stock CAAS = new Stock("CAAS", 32.2f, 31.5f, calendar.getTime());
		portfolio.addStock(new Stock("PIH", 13.1f, 12.4f, calendar.getTime()));
		portfolio.addStock(AAL);
		portfolio.addStock(CAAS);
		
		return portfolio;
		
		
	}
}

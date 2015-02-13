package com.myprojec.javacourse.service;


import java.util.Calendar;



import java.util.Date;

import com.myproject.javacourse.model.Portfolio;
import com.myproject.javacourse.model.Stock;

public class PortfolioManager {

	private Portfolio _portfolio;
	private Portfolio myPortfolio;
	
	Calendar calendar = Calendar.getInstance();
	Stock PIH;
	Stock AAL;
	Stock CAAS;


	
	public PortfolioManager(){
		calendar.set(2014, Calendar.DECEMBER, 15);
		PIH = new Stock("PIH", 10.0f, 8.5f, calendar.getTime());
		AAL = new Stock("AAL", 30.0f, 25.5f, calendar.getTime());
		CAAS = new Stock("CAAS", 20.0f, 15.5f, calendar.getTime());

		
		myPortfolio = new Portfolio();
		myPortfolio.settitle("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000);
		
		myPortfolio.buyStock(PIH, 20);
		myPortfolio.buyStock(AAL, 30);
		myPortfolio.buyStock(CAAS, 40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");	

	}
	
	public Portfolio getPortfolio(){


		
	//	myPortfolio.getStockArr();

		
//		_portfolio.addStock(new Stock("PIH", 13.1f, 12.4f, calendar.getTime()));
//		_portfolio.addStock(new Stock("AAL", 5.78f, 5.5f, calendar.getTime()));
//		_portfolio.addStock(new Stock("CAAS", 32.2f, 31.5f, calendar.getTime()));
//		
//		_portfolio.addStock(new Stock("PIH", 10.0f, 8.5f, calendar.getTime()));
//		_portfolio.addStock(new Stock("AAL", 30.0f, 25.5f, calendar.getTime()));
//		_portfolio.addStock(new Stock("CAAS", 20.0f, 15.5f, calendar.getTime()));
		
		return myPortfolio;
		
		
	}
}

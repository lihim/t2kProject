package com.myproject.javacourse.model;

import com.myproject.javacourse.Stock;

public class Portfolio {

	private String title;
	private  final int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private static int portfolioSize;
	
	public Portfolio(){
		title = "lihi's Portfolio";
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}
	
	public void addStock(Stock stock){
		
		stocks[portfolioSize] = stock;

		portfolioSize++;
	}
	
	public Stock[] getStock(){
		return stocks;
	}
	
	public String getHtmlString(){
		String res;
		res = "<h1>"+title+"</h1>";
		
		for(int i = 0 ; i<stocks.length ; i++){
			if(stocks[i] != null){
				res += stocks[i].getHtmlDescription();
				res+="<br>";
			}
		}
		return res;
	}
}

package com.myproject.javacourse.model;

import org.mortbay.io.Portable;

import com.myproject.javacourse.Stock;

public class Portfolio {

	private String _title;
	private  final int MAX_PORTFOLIO_SIZE = 5;
	private Stock []_stocks;
	private static int _portfolioSize;
	


	public Portfolio(String portfolioName){
		_title = portfolioName;
		_stocks = new Stock[MAX_PORTFOLIO_SIZE];
		_portfolioSize = 0;
	}
	
	public String getTitle(){
		return _title;
		
	}
	
	public void addStock(Stock stock){
		
		_stocks[_portfolioSize] = stock;

		_portfolioSize++;
	}
	
	public Stock[] getStock(){
		return _stocks;
	}
	
	public String getHtmlString(){
		String res;
		res = "<h1>"+_title+"</h1>";
		
		for(int i = 0 ; i<_stocks.length ; i++){
			if(_stocks[i] != null){
				res += _stocks[i].getHtmlDescription();
				res+="<br>";
			}
		}
		return res;
	}
	
}

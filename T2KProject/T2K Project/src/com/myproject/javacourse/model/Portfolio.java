package com.myproject.javacourse.model;

import org.mortbay.io.Portable;

public class Portfolio {

	private String _title;
	private  final int MAX_PORTFOLIO_SIZE = 5;
	private Stock []_stocks;
	private int _portfolioSize;
	

	public Portfolio(Portfolio portfolio){
		_title = portfolio.getTitle();
		_stocks = new Stock[MAX_PORTFOLIO_SIZE];
		
		for(int i  = 0 ; i< portfolio.getPortfolioSize() ; i++){
			_stocks[i] = new Stock(portfolio.getStock(i));
			this._portfolioSize++;
		}
		
		
	}
	
	public int getPortfolioSize(){
		return _portfolioSize;
	}
	public void settitle(String name){
		_title = name;
	}

	public Portfolio(String portfolioName){
		_title = portfolioName;
		_stocks = new Stock[MAX_PORTFOLIO_SIZE];
		_portfolioSize = 0;
	}

	//return one stock from the stocks arr
	public Stock getStock(int index){
		return _stocks[index];
	}
	
	public String getTitle(){
		return _title;
		
	}
	
	public void removeStock(int index){
		
		for(int i = index ; i< _stocks.length -1 ; i++){

			_stocks[i] = _stocks[i+1];

		}
		_stocks[_stocks.length - 1] = null;
		
		
	}
	
	public void addStock(Stock stock){
		
		_stocks[_portfolioSize] = stock;

		_portfolioSize++;
	}
	
	//returns the whole stock arr
	public Stock[] getStockArr(){
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

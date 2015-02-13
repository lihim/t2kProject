package com.myproject.javacourse.model;


public class Portfolio {

	enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	private float _balance;
	private String _title;
	private  final int MAX_PORTFOLIO_SIZE = 5;
	private Stock []_stocks;
	private int _portfolioSize;
	

	public Portfolio(){
		this("");
		
	}
	
	public Portfolio(Portfolio portfolio){
		_title = portfolio.getTitle();
		_stocks = new Stock[MAX_PORTFOLIO_SIZE];
		
		for(int i  = 0 ; i< portfolio.getPortfolioSize() ; i++){
			_stocks[i] = new Stock(portfolio.getStock(i));
			this._portfolioSize++;
		}
	}
	
	public Portfolio(String portfolioName){
		_title = portfolioName;
		_stocks = new Stock[MAX_PORTFOLIO_SIZE];
		_portfolioSize = 0;
		_balance = 0;
	}

	//return one stock from the stocks array
	public Stock getStock(int index){
		return _stocks[index];
	}
	
	public Stock getStock(String symbol){
		for(int i = 0 ; i<_portfolioSize ; i++){
			if(_stocks[i].get_symbol() == symbol){
				return _stocks[i];
			}
		}
		return null;
	}
	
	public String getTitle(){
		return _title;
		
	}
	
	public int getPortfolioSize(){
		return _portfolioSize;
	}
	
	public void settitle(String name){
		_title = name;
	}
	
	public void removeStock(int index){
		
		for(int i = index ; i< _portfolioSize-1 ; i++){
			_stocks[i] = _stocks[i+1];
		}
		_stocks[_portfolioSize - 1] = null;
	}
	
	public void addStock(Stock stock){
		
		if(!(isStockExist(stock.get_symbol()))){
			if(_portfolioSize < MAX_PORTFOLIO_SIZE){
				_stocks[_portfolioSize] = stock;
				_portfolioSize++;
			}
			else{
				System.out.println("Can’t add new stock, portfolio can have only "+ MAX_PORTFOLIO_SIZE + " stocks...");
				System.exit(1);
			}
		}
	}

	
	/**
	 * @param symbol
	 * @return true if stock with symbol name exist else return false
	 */
	public boolean isStockExist(String symbol){
		for(int i = 0 ; i<_portfolioSize ; i++){
			if(_stocks[i].get_symbol() == symbol){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param symbol
	 * @return the index of the current stock in the stock arrays else returns -1
	 */
	public int getStockIndex(String symbol){
		for(int i = 0 ; i<_portfolioSize ; i++){
			if(_stocks[i].get_symbol() == symbol){
				return i;
			}
		}
		return -1;
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
	
	public void updateBalance(float amount){
		if(this._balance + amount < 0  ){
			System.out.println("Not enough balance to complete purchase.");
			
		}
		else{
			this._balance = amount;
		}
	}
	
	public boolean removeStock(String symbol){
		
		if(isStockExist(symbol)){
			sellStock(symbol, getStock(symbol).getStockQuantity());
			removeStock(getStockIndex(symbol));
			return true;
		}
		return false;
	}
	
	public boolean sellStock(String symbol, int quantity){
		
		Stock currentStock = getStock(symbol);
		if(quantity < 0){
			quantity = currentStock.getStockQuantity();
		}
		if(currentStock != null){
			//checks if there are enough stocks to sell in the portfolio  
			if(currentStock.getStockQuantity()-quantity >=0){
				currentStock.setStockQuantity(currentStock.getStockQuantity()-quantity);
				//updating the _balance after selling
				_balance += (quantity*currentStock.get_bid());
			}
			else{
				System.out.println("Not enough stocks to sell.");
			}
		}
		return true;
	}
	
	public boolean buyStock(Stock stock, int quantity){
		
		float askValue = stock.get_ask();
		int numOfStockToBuy;
		if(_balance < askValue){
			return false;
		}
			
		if(quantity == -1){
			numOfStockToBuy = 0;
			while((_balance - askValue) > askValue){
				numOfStockToBuy++;
			}
		}
		else{
			numOfStockToBuy = quantity;
		}
		
		Stock currentStock; 
		
		if(isStockExist(stock.get_symbol())){
			_stocks[getStockIndex(stock.get_symbol())].setStockQuantity(stock.getStockQuantity() + numOfStockToBuy);
		}
		else{
			currentStock = new Stock(stock);
			addStock(currentStock);
			currentStock.setStockQuantity(numOfStockToBuy);
		}
		
		_balance -= (numOfStockToBuy*askValue);
		return true;
	}
	
	public String toString(){
		return getHtmlString();
	}
	
}

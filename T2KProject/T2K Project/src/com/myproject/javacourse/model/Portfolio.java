package com.myproject.javacourse.model;

public class Portfolio {

	enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	private String _title;
	private  final int MAX_PORTFOLIO_SIZE = 5;
	private Stock []_stocks;
	private int _portfolioSize;
	private float _balance;

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

	//return one stock from the stocks array by an index
	public Stock getStock(int index){
		return _stocks[index];
	}
	
	//return one stock from the stocks array by the stock name
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
	
	public float getBalance(){
		return _balance;
	}
	
	/**
	 * updating the balnace value according to the amount parameter
	 * @param amount
	 */
	public void updateBalance(float amount){
		if(this._balance + amount < 0  ){
			System.out.println("Not enough balance to complete purchase.");
		}
		else{
			this._balance += amount;
		}
	}

	/**
	 * adding stock to the stockes array
	 * @param stock
	 */
	public void addStock(Stock stock){
		
		//if this stock is not exist in the stocks array add it
		if(!(isStockExist(stock.get_symbol()))){
			if(_portfolioSize < MAX_PORTFOLIO_SIZE){
				_stocks[_portfolioSize] = stock;
				_stocks[_portfolioSize].setStockQuantity(0);
				_portfolioSize++;
			}
			else{
				System.out.println("Can’t add new stock, portfolio can have only "+ MAX_PORTFOLIO_SIZE + " stocks...");
			}
		}
	}

	/**
	 * @return the total value of all stocks
	 */
	public float getStockValue(){
		
		float value = 0;
		
		for(int i = 0 ; i<_portfolioSize-1 ; i++){
			value+=(_stocks[i].get_bid()*_stocks[i].getStockQuantity());
		}
		return value;
	}
	
	/**
	 * @return the sum of all stocks’ value and portfolio’s balance.
	 */
	public float getTotalValue(){
		return getStockValue() + getBalance();
	}
	
	/**
	 * @param symbol, th name of the stock
	 * @return true if stock with symbol name exist else return false
	 */
	private boolean isStockExist(String symbol){
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
	private int getStockIndex(String symbol){
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
		res+="<br>";
		res += "Total Portfolio Value: " + getTotalValue() + "$ <br>Total Stocks value: " 
				+ getTotalValue() + "$ <br> Balance: " + getBalance() + "$";

		return res;
	}

	public void removeStock(int index){
		//checking if the index is valid
		if(index < _portfolioSize){
			for(int i = index ; i< _portfolioSize-1 ; i++){
				_stocks[i] = _stocks[i+1];
			}
			_stocks[_portfolioSize - 1] = null;
			_portfolioSize--;
		}
		else{
			System.out.println("Error: there is no stock in this index");
		}

	}
	

	/**
	 * @param symbol
	 * @return true if the delete operation success other wise returns false 
	 */
	public boolean removeStock(String symbol){
		
		if(isStockExist(symbol)){
			//selling the whole stock
			sellStock(symbol, -1);
			//removing the stock from the stocks array
			removeStock(getStockIndex(symbol));
			return true;
		}
		//there is no such stock in portfolio
		return false;
	}
	
	
	/**
	 * @param symbol, the name of the stock
	 * @param quantity, the mount of stocks to sell
	 * @return true if the sell operation was a success or false if not 
	 */
	public boolean sellStock(String symbol, int quantity){
		
		//checking if the stock we need to sell exist in out portfolio
		if(isStockExist(symbol)){
			Stock currentStock = getStock(symbol);
			
			//if we need to sell all whole stock we need to update the quantity value to sell
			if(quantity < 0){
				//getting the quantity of the stock  
				quantity = currentStock.getStockQuantity();
			}

			//checks if there are enough stocks to sell in the portfolio  
			if(currentStock.getStockQuantity()-quantity >=0){
				//updating the quantity of the stock after selling
				currentStock.setStockQuantity(currentStock.getStockQuantity()-quantity);
				//updating the _balance after selling
				updateBalance(quantity*currentStock.get_bid());
				
			}
			else{
				System.out.println("Not enough stocks to sell.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param stock, the name of the stock
	 * @param quantity, the mount of stocks to buy
	 * @return true if the operation was a success other wise returns false
	 */
	public boolean buyStock(Stock stock, int quantity){
		
		float askValue = stock.get_ask();
		int numOfStockToBuy;
		Stock currentStockToBuy; 
		if(_balance < askValue){
			return false;
		}
			
		//if the user ask to buy as many stocks as his balance can purchase
		if(quantity == -1){
			numOfStockToBuy = 0;
			//calculate how many stocks the user can buy with his current balance
			while((_balance - askValue) > askValue){
				numOfStockToBuy++;
			}
		}
		//if the user ask to buy a specific mount of stocks;
		else{
			numOfStockToBuy = quantity;
		}

		//checking if the stock exist in the portfolio 
		if(isStockExist(stock.get_symbol())){
			_stocks[getStockIndex(stock.get_symbol())].setStockQuantity(stock.getStockQuantity() + numOfStockToBuy);
		}
		else{//if the stock doesnt exist in the portfolio
			//creating new stock
			currentStockToBuy = new Stock(stock);
			//adding it to the portolio stocks array
			addStock(currentStockToBuy);
			//set the quantity of the new stock according to the user request of mount
			currentStockToBuy.setStockQuantity(numOfStockToBuy);
		}
		
		updateBalance(-(numOfStockToBuy*askValue));
		
		return true;
	}
	
	public String toString(){
		return getHtmlString();
	}
	
}

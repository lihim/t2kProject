package com.myproject.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.myproject.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

public class Stock {

	
	private String _symbol;
	private float _ask;
	private float _bid;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	public Stock(Stock stock){
		this(stock.get_symbol(), stock.get_ask(), stock.get_bid(), stock.getDate());
	}
	
	public Stock(String symbol, float ask, float bid, Date date) {
		
		set_ask( ask);
		set_bid( bid);
		set_symbol(symbol);
		setDate( date);
		
	}



	public String getHtmlDescription(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		String stockHtmlDetailsString;

		stockHtmlDetailsString = "<b>Stock symbol:</b> " +_symbol+ " <b>Bid:</b> "
				+_bid + " <b>ask:</b> " + _ask + " <b>date:</b> "+ dateFormat.format(getDate()) 
				+ " <b>quantity:</b> " + stockQuantity;
				
		return stockHtmlDetailsString;
	}
	


	public String get_symbol() {
		return _symbol;
	}
	public void set_symbol(String _symbol) {
		this._symbol = _symbol;
	}
	public float get_ask() {
		return _ask;
	}
	public void set_ask(float _ask) {
		this._ask = _ask;
	}
	public float get_bid () {
		return _bid;
	}
	public void set_bid(float _bid) {
		this._bid = _bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = new Date(date.getTime());
	}
	
	
}

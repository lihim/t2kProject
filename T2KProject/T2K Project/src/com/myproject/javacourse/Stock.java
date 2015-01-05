package com.myproject.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {

	private String _symbol;
	private float _ask;
	private float _bid;
	private Date date;
	
	public Stock(String symbol, double ask, double bid, Date date){
		this._ask = (float) ask;
		this._bid = (float) bid;
		this._symbol = symbol;
		this.date = date;
	}

	public String getHtmlDescription(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		String stockHtmlDetailsString;

		stockHtmlDetailsString = "<b>Stock symbol:</b> " +get_symbol()+ " <b>Bid:</b> "
				+get_bid() + " <b>ask:</b> " + get_ask() + " <b>date:</b> "+ dateFormat.format(getDate());
				
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
		this.date = date;
	}
	
	
}

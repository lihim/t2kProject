package com.myproject.javacourse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Stock {

	private String _symbol;
	private float _ask;
	private float _bid;
	private Date date;
	private int recommendation;
	private int stockQuantity;
	private final static int BUY = 0;
	private final static int SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
	
	




	public Stock(String symbol, float ask, float bid, int year, int mounth, int day) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, mounth-1, day);
		
		set_ask( ask);
		set_bid( bid);
		set_symbol(symbol);
		setDate( calendar.getTime());
	}



	public String getHtmlDescription(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		String stockHtmlDetailsString;

		stockHtmlDetailsString = "<b>Stock symbol:</b> " +_symbol+ " <b>Bid:</b> "
				+_bid + " <b>ask:</b> " + _ask + " <b>date:</b> "+ dateFormat.format(getDate());
				
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

package il.ac.mta.stock.model;

import java.util.Date;

public class Stock {
	
	 String symbol;
	 double ask, bid;
	 Date date;

	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public double getAsk() {
		return ask;
	}


	public void setAsk(double ask) {
		this.ask = ask;
	}


	public double getBid() {
		return bid;
	}


	public void setBid(double bid) {
		this.bid = bid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHtmlDescription() {
		String stockDetails = new String("<b>stock symbol: </b>" + this.getSymbol() + "<br>" + "<b>stock ask: </b>" + this.getAsk() + "<br>" + "<b>stock bid: </b>" + this.getBid() + "<br>" + "<b>stock date: </b>" + this.getDate() + "<p>");
		return stockDetails;
	}
	
	public Stock(){
		
	}
	//constructor
	public Stock(String symbol, double ask, double bid, Date date){
		setAsk(ask);
		setSymbol(symbol);
		setBid(bid);
		setDate(date);
	}
	
	//copy constructor
	public Stock (Stock stock){
		setAsk(stock.getAsk());
		setSymbol(stock.getSymbol());
		setBid(stock.getBid());
		setDate(stock.getDate());
	}
}

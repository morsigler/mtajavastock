package il.ac.mta.stock.model;

import java.util.Date;

public class Stock {
	
	 private String symbol;
	 private float ask, bid;
	 private Date date;
	 
	public Stock(){
		
	}
	
	//constructor
	public Stock(String symbol, float ask, float bid, Date date){
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

	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public float getAsk() {
		return ask;
	}


	public void setAsk(float ask) {
		this.ask = ask;
	}


	public float getBid() {
		return bid;
	}


	public void setBid(float bid) {
		this.bid = bid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHtmlDescription() {
		return ("<b>stock symbol: </b>" + this.getSymbol() + "<br>" + "<b>stock ask: </b>" + 
				this.getAsk() + "<br>" + "<b>stock bid: </b>" + this.getBid() + "<br>" + "<b>stock date: </b>" + 
				this.getDate()+"<br>");
	}
}

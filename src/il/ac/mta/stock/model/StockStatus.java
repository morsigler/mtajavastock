package il.ac.mta.stock.model;

import java.util.Date;

public class StockStatus extends Stock {
	
	public enum ALGO_RECOMMENDATION{
		DO_NOTHING,
		BUY,
		SELL
	}
	
	ALGO_RECOMMENDATION recommendation;
	int stockQuantity;
	
	public	StockStatus()
	{
		super.setSymbol("empty");
		super.setAsk(0);
		super.setBid(0);
		super.setDate(null);
		recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}
	
	public StockStatus(Stock stock){
		super (stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;	
		
	}
	
	public StockStatus(StockStatus stockStatus){
		this.setAsk(stockStatus.getAsk());
		this.setBid(stockStatus.getBid());
		this.setDate(stockStatus.getDate());
		this.setRecommendation(stockStatus.getRecommendation());
		this.setStockQuantity(stockStatus.getStockQuantity());
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}

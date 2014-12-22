/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.model;

import java.util.Date;

	public class Portfolio{
		
		public enum ALGO_RECOMMENDATION{
			DO_NOTHING,
			BUY,
			SELL
		}
		
		public class StockStatus {
			String symbol;
			double currentBid, currentAsk;
			Date date;
			ALGO_RECOMMENDATION recommendation;
			int stockQuantity;
			
			
			public String getSymbol() {
				return symbol;
			}
			public void setSymbol(String symbol) {
				this.symbol = symbol;
			}
			public double getCurrentBid() {
				return currentBid;
			}
			public void setCurrentBid(double currentBid) {
				this.currentBid = currentBid;
			}
			public double getCurrentAsk() {
				return currentAsk;
			}
			public void setCurrentAsk(double currentAsk) {
				this.currentAsk = currentAsk;
			}
			public Date getDate() {
				return date;
			}
			public void setDate(Date date) {
				this.date = date;
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
		
			//c'tor
			public	StockStatus()
			{
				symbol = "empty";
				currentAsk = 0;
				currentBid = 0;
				date = new Date();
				recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
				stockQuantity = 0;
			}
		
			// copy c'tor
			public StockStatus (StockStatus stockStatus)
			{
	              setSymbol(stockStatus.symbol);
	              setCurrentAsk(stockStatus.currentAsk);
	              setCurrentBid(stockStatus.currentBid);
	              setDate(stockStatus.date);
	              setRecommendation(stockStatus.recommendation);
	              setStockQuantity(stockStatus.stockQuantity);
			}
		}
		
		static final private int MAX_PORTFOLIO_SIZE = 5;
		String title;
		private Stock[] stocks;
		private StockStatus[] stocksStatus;
		int portfolioSize;
		
		public Portfolio (){
			stocks = new Stock[MAX_PORTFOLIO_SIZE];
			stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
			portfolioSize =0;
			}
			
		//c'tor
		public Portfolio (String title)
		{
			this();
			setTitle(title);
		}
	
		//copy c'tor
		public Portfolio(Portfolio portfolio)
		{
			this();
			setTitle(portfolio.getTitle());
			setPortfolioSize(portfolio.getPortfolioSize());

		     for (int i = 0; i < portfolioSize; i++) {
	           stocks[i] = new Stock(portfolio.getStocks()[i]);
	           }
		     
		     for(int j = 0; j < portfolioSize; j++){
		    	 stocksStatus[j] = new StockStatus(portfolio.getStocksStatus()[j]);
		    	 }
		}

		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public StockStatus[] getStocksStatus() {
			return stocksStatus;
		}

		public void setStocksStatus(StockStatus[] stocksStatus) {
			this.stocksStatus = stocksStatus;
		}

		public int getPortfolioSize() {
			return portfolioSize;
		}

		public void setPortfolioSize(int portfolioSize) {
			this.portfolioSize = portfolioSize;
		}

		public void setStocks(Stock[] stocks) {
			this.stocks = stocks;
		}
		
		public Stock[] getStocks() {
			return stocks;
		}

		//adding stocks to array
		public void addStock (Stock stock) {
			if (portfolioSize < MAX_PORTFOLIO_SIZE){
					stocks[portfolioSize] = stock;
					stocksStatus[portfolioSize] = new StockStatus();
					portfolioSize++;
			}
		}
		
		//printing stocks
		public String getHtmlString(){
			String rst = new String("<h1>"+this.title+"</h1>"+"<br>");
			for (int i=0; i<portfolioSize; i++){
				rst += this.stocks[i].getHtmlDescription();
			}	
			
			return rst;
			
		}
		
	}
	
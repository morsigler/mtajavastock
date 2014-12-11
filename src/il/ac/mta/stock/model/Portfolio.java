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
		
		public class StockStatus {
			
			static final public int DO_NOTHING = 0;
			static final public int BUY = 1;
			static final public int SELL = 2;
			
			String symbol;
			double currentBid, currentAsk;
			Date date;
			int recommendation, stockQuantity;
			
			
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
			public int getRecommendation() {
				return recommendation;
			}
			public void setRecommendation(int recommendation) {
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
				recommendation = DO_NOTHING;
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
			setTitle(title);
		}
	
		//copy c'tor
		public Portfolio(Portfolio portfolio)
		{
			setTitle(portfolio.getTitle());
			setPortfolioSize(portfolio.getPortfolioSize());

		     for (int i = 0; i < portfolioSize; i++) 
	             stocks[i] = new Stock(portfolio.getStocks()[i]);

		     for(int i = 0; i < portfolioSize; i++)
		    	 stocksStatus[i] = new StockStatus (portfolio.getStocksStatus()[i]);
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
			if (portfolioSize < 5){
					this.stocks[portfolioSize] = stock;
					portfolioSize++;
			}
		}
		
		//printing stocks
		public String getHtmlString(){
			String title = new String("<h1>"+this.title+"</h1>"+"<br>");
			String rst = new String();
			for (int i=0; i<portfolioSize; i++){
				rst += this.stocks[i].getHtmlDescription();
			}	
			
			return rst;
			
		}
		
	}
	
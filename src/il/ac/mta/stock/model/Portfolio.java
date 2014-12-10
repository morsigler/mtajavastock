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
			
		}
		
		static final private int MAX_PORTFOLIO_SIZE = 5;
		String title;
		private Stock[] stocks;
		private StockStatus[] stocksStatus;
		int portfolioSize =0;
		
		public Portfolio (){
			stocks = new Stock[MAX_PORTFOLIO_SIZE];
			stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
			
			}
		
		//adding stocks to array
		public void addStock (Stock stock) {
			if (portfolioSize < 5){
					this.stocks[portfolioSize] = stock;
					portfolioSize++;
			}
		}
		
		public Stock[] getStocks (){
			return this.stocks;
		
		}
		
		public String getHtmlString(){
			String title = new String("<h1>"+this.title+"</h1>"+"<br>");
			String rst = new String();
			for (int i=0; i<portfolioSize; i++){
				rst += this.stocks[i].getHtmlDescription();
			}	
			
			return rst;
			
		}
		

		
	}
	
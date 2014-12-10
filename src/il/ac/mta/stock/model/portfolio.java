/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.model;

import java.util.Date;

import il.ac.mta.Stock;

	public class portfolio{
		
		public class StockStatus {
			
			static final public int DO_NOTHING = 0;
			static final public int BUY = 1;
			static final public int SELL = 2;
			
			String symbol;
			double currentBid, currentAsk;
			Date date;
			int recommendation, stockQuantity;
			
		}
		
		public portfolio (){
			stocks = new Stock[MAX_PORTFOLIO_SIZE];
			stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
			
			}
		
		static final private int MAX_PORTFOLIO_SIZE = 5;
		String title;
		private Stock[] stocks;
		private StockStatus[] stocksStatus;
		int portfolioSize =0;
		
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
				rst += "<b>stock symbol: </b>" + this.stocks[i].getSymbol() + "<br>" + 
						"<b>stock ask: </b>" + this.stocks[i].getAsk() + "<br>"+
						"<b>stock bid: </b>" + this.stocks[i].getBid() + "<br>" + 
						"<b>stock date: </b>" + this.stocks[i].getDate() + "<br>"+"<p>";
			}	
			return rst;
			
		}
		

		
	}
	
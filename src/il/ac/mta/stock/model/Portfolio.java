/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.model;

import il.ac.mta.exception.BalanceException;
import il.ac.mta.exception.PortfolioFullException;
import il.ac.mta.exception.StockAlreadyExistsException;
import il.ac.mta.exception.StockNotExistException;

import java.util.Date;

	public class Portfolio{
		
		static final private int MAX_PORTFOLIO_SIZE = 5;
		private String title;
		private StockStatus[] stocksStatus;
		private int portfolioSize;
		private float balance;
		
		public Portfolio (){
			stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
			portfolioSize =0;
			balance = 0;
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
		
		public float getBalance() {
			return balance;
		}

		
		//adding stocks to array
		public void addStock (Stock stock) throws PortfolioFullException, StockAlreadyExistsException {
						
							for (int i=0; i< getPortfolioSize(); i++){
								if (stock.getSymbol().equals(getStocksStatus()[i].getSymbol()))
									throw new StockAlreadyExistsException(stock.getSymbol());
								}
			
							if (portfolioSize >= MAX_PORTFOLIO_SIZE)
								throw new PortfolioFullException();
							else {
									stocksStatus[portfolioSize] = new StockStatus(stock);
									portfolioSize++;
							}
					}
		//remove stocks from array
		public void removeStock (String stockSymbol) throws StockNotExistException{
					for(int i=0; i< MAX_PORTFOLIO_SIZE; i++){
							if (stocksStatus[i].getSymbol().equals(stockSymbol)){
								sellStock(stocksStatus[i].getSymbol(),-1);
								if (i != portfolioSize-1){ // if the stock we remove is not at the end of the array
									this.getStocksStatus()[i] = this.getStocksStatus()[portfolioSize-1];
								}
								this.getStocksStatus()[portfolioSize-1] = new StockStatus();
								portfolioSize--;
								return;
							}
						}
						return;
					}

		//printing stocks
		public String getHtmlString(){
			String rst = new String("<h1>"+this.title+"</h1>"+"<br>");
			for (int i=0; i<portfolioSize; i++){
				rst += this.stocksStatus[i].getHtmlDescription();
			}		
			return rst;	
		}
		
		//selling stock
		public void sellStock(String symbol, int quantity) throws StockNotExistException{
						float sellProfit;
						for(int i=0; i< this.getPortfolioSize(); i++){
							if (stocksStatus[i].getSymbol().equals(symbol)){// searching for the stock in stocks array
								if (quantity <0 || quantity > stocksStatus[i].getStockQuantity()){// if the quantity is -1 or you want to sell more than you have
									sellProfit = (float) (stocksStatus[i].getStockQuantity() * stocksStatus[i].getBid());// the profit is all the amount of stocks left
									stocksStatus[i].setStockQuantity(0);
								}
								else {
									sellProfit = (float) (quantity * stocksStatus[i].getBid()); //the profit is only the amount we asked to sell
									stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity()-quantity); //dropping the amount of the stocks after we sold part of it
								}
								updateBalance(sellProfit);
								return;
							}
							
						}
						throw new StockNotExistException(symbol);
					}
		
		//buying stock
		public void buyStock(String symbol, int quantity) throws BalanceException{
			int howManyStocks; 			
			for(int i=0; i< this.getPortfolioSize(); i++){
				if (stocksStatus[i].getSymbol().equals(symbol)){
					if (quantity < 0){ // buy with all balance
						howManyStocks = (int) (this.balance / stocksStatus[i].getAsk());
						stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + howManyStocks);
						this.balance = 0;
					} 
					else {
						if(quantity * stocksStatus[i].getAsk() > this.balance){//checking that balance won't be negative
							throw new BalanceException();
						}
						else{
							stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + quantity);
							updateBalance(-(float) (quantity * stocksStatus[i].getAsk()));
								return;
							}
						}
					}
				}
				return;	
			}
		
		// adding amount to balance
		public void updateBalance(float amount){
			this.balance += amount;
		}
		
		//get stocks value
		public float getStocksValue(){
			float stocksSum=0;
			for (int i=0; i<portfolioSize; i++){
				stocksSum += stocksStatus[i].getStockQuantity()* stocksStatus[i].getBid();
			}
			return stocksSum;
		}
		
		//get total portfolio value
		public float getPortfolioValue(){
			return this.getBalance() + this.getStocksValue();
		}
		
		//printing portfolio
		public String getHtmlDescription(){
			String rst = new String ("<b>"+ getTitle()+"<p></b>");
			for (int i=0; i<getPortfolioSize(); i++){
				rst += getStocksStatus()[i].getHtmlDescription();
				rst += "stock quantity is: " + getStocksStatus()[i].getStockQuantity()+"<p>";
			}
			return rst;
		}
	}
	
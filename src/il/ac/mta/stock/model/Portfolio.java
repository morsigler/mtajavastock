/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.model;

import il.ac.mta.exception.BalanceException;
import il.ac.mta.exception.IllegalQuantityException;
import il.ac.mta.exception.PortfolioFullException;
import il.ac.mta.exception.StockAlreadyExistsException;
import il.ac.mta.exception.StockNotExistException;

import java.util.Date;
import java.util.List;

public class Portfolio {
	
	public static final int MAX_PORTFOLIO_SIZE = 5;
	public static final int SELL_ALL = -1;
	private String title;
	private int portfolioSize;
	private StockStatus[] stocksStatus;
	private float balance;
	
	public Portfolio() {
		this.balance = 0;
		this.portfolioSize = 0;
		this.stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}
	public Portfolio(String title) {
		this();
		this.setTitle(title);
	}
	public Portfolio(List<StockStatus> stocksStatus) throws StockAlreadyExistsException, PortfolioFullException {
		this();
		for (StockStatus stockStatus : stocksStatus) {
			this.addStock(new StockStatus(stockStatus));
		}
	}
	public Portfolio(Portfolio portfolio) throws StockAlreadyExistsException, PortfolioFullException {
		this(portfolio.getTitle());
		
		int portfolioSize = portfolio.getPortfolioSize();
		StockStatus[] stocksStatus = portfolio.getStocksStatus();
		
		for (int i=0; i<portfolioSize; i++) {
			this.addStock(new StockStatus(stocksStatus[i]));
		}	
		
		this.setBalance(portfolio.getBalance());
	}
	
	
	public void addStock(Stock stock) throws StockAlreadyExistsException, PortfolioFullException {
		if (this.portfolioSize == MAX_PORTFOLIO_SIZE) {
			throw new PortfolioFullException(); 
		}
		
		if (this.isStockExistInPortfolio(stock.getSymbol())) {
			throw new StockAlreadyExistsException(stock.getSymbol());
		}
		
		this.stocksStatus[this.getPortfolioSize()] = new StockStatus(stock);
		this.portfolioSize++;	
	}
	
	
	
	public void removeStock(String symbol) throws StockNotExistException, IllegalQuantityException {
		int stockIndex;
		
		if (this.isStockExistInPortfolio(symbol)) {
			this.sellStock(symbol, SELL_ALL);
			stockIndex = this.getStockStatusIndexBySymbol(symbol);
			this.stocksStatus[stockIndex] = this.stocksStatus[this.getPortfolioSize() - 1];
			this.portfolioSize--;
		}
		else {
			throw new StockNotExistException(symbol);
		}
	}
	


	public void sellStock(String symbol, int quantity) throws StockNotExistException, IllegalQuantityException {	
		if (quantity != SELL_ALL && quantity < 1) {
			throw new IllegalQuantityException("You asked to sell invalid quantity");
		}		
		else {
			if (this.isStockExistInPortfolio(symbol)) {
				StockStatus stockStatus = this.findBySymbol(symbol);
				int currentQuantity = stockStatus.getStockQuantity();
				int quantityToSell = (quantity == SELL_ALL) ? currentQuantity : quantity;
				if (quantityToSell > currentQuantity) {
					throw new IllegalQuantityException("Not enough stocks to sell");	
				}
				else {
					float currentBid = stockStatus.getBid();
					stockStatus.setStockQuantity(-(quantityToSell));
					
					float additionToBalance = quantityToSell * currentBid;
					this.updateBalance(additionToBalance);	
				}
			}
			else {
				throw new StockNotExistException(symbol);	
			}
		}
	}
	


	public void buyStock(String symbol, int quantity) throws IllegalQuantityException, BalanceException, StockNotExistException {	
		if (quantity < 1) {
			throw new IllegalQuantityException("You asked to buy invalid quantity");
		}	
		else {
			if (this.isStockExistInPortfolio(symbol)) {
				StockStatus stockStatus = this.findBySymbol(symbol);
				float currentAsk = stockStatus.getAsk();
				float price = quantity * currentAsk;
				float currentBalance = this.getBalance();
				if (price > currentBalance) {
					throw new BalanceException();		
				}
				else {
					stockStatus.setStockQuantity(quantity);
					this.updateBalance(-(price));	
				}
			}
			else {
				throw new StockNotExistException(symbol);	
			}	
		}
	}
	
	


	private boolean isStockExistInPortfolio(String symbol) {
		boolean exist = false;
		for (int i=0; i<this.portfolioSize; i++) {
			if (this.stocksStatus[i].getSymbol().equals(symbol)) {
				exist = true;
				break;
			}
		}
		return exist;
	}


	public StockStatus findBySymbol(String symbol) {
		StockStatus stockStatus = null;
		for (int i=0; i<this.portfolioSize; i++) {
			if (this.stocksStatus[i].getSymbol().equals(symbol)) {
				stockStatus = this.stocksStatus[i];
				break;
			}
		}
		return stockStatus;
	}
	
	private int getStockStatusIndexBySymbol(String symbol) {
		int index = 0;
		for (int i=0; i<this.portfolioSize; i++) {
			if (this.stocksStatus[i].getSymbol().equals(symbol)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int getPortfolioSize() {
		return this.portfolioSize;
	}
	public StockStatus[] getStocks() {
		return this.stocksStatus;
	}
	
	public StockStatus[] getStocksStatus() {
		return this.stocksStatus;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getBalance() {
		return this.balance;
	}
	public void updateBalance(float diff) {
		this.balance += diff;
	}
	
	public float getStocksValue() {
		int stockQuantity;
		float stockBid;
		
		float stocksValue = 0;
		for (int i=0; i<this.getPortfolioSize(); i++) {
			stockQuantity = this.stocksStatus[i].getStockQuantity();
			stockBid = this.stocksStatus[i].getBid();
			stocksValue += (stockQuantity * stockBid);	
		}
		return stocksValue;
	}
	
	public float getTotalValue() {
		return this.getStocksValue() + this.getBalance();
	}
	


	public String getHtmlString() {
		String portfolioStr = "";
		portfolioStr += "<h1>" + this.getTitle() + "</h1>";
		portfolioStr += "<b>Total portfolio value:</b> " + this.getTotalValue() +"$ " +
						"<b>Total stocks value:</b> " + this.getStocksValue() +"$ " +
						"<b>Balance:</b> " + this.getBalance() +"$ <br/><br/>";
				
		for (int i=0; i<this.getPortfolioSize(); i++) {
			portfolioStr += this.stocksStatus[i].getHtmlDescription() + "<br/>";	
		}
		return portfolioStr;
	}
}
	
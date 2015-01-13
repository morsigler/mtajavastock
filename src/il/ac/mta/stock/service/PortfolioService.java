/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import il.ac.mta.exception.BalanceException;
import il.ac.mta.exception.PortfolioFullException;
import il.ac.mta.exception.StockAlreadyExistsException;
import il.ac.mta.exception.StockNotExistException;
import il.ac.mta.stock.model.Stock;
import il.ac.mta.stock.model.Portfolio;

	public class PortfolioService{
		
		
		public Portfolio getPortfolio() throws PortfolioFullException, StockAlreadyExistsException, StockNotExistException, BalanceException {
			
			Portfolio myPortfolio;
			myPortfolio = new Portfolio("Exercise 7 portfolio");
			
			Stock stock1, stock2, stock3,stock4,stock5,stock6 ;
			stock1 = new Stock();
			stock2 = new Stock();
			stock3 = new Stock();
			stock4 = new Stock();
			stock5 = new Stock();
			stock6 = new Stock();
			
			
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			Date stockDate = null;
			try {
				stockDate = formatter.parse("11/15/2014");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			stock1.setSymbol("PIH");
			stock1.setAsk((float) 10);
			stock1.setBid((float) 8.5);
			stock1.setDate(stockDate);

			stock2.setSymbol("AAL");
			stock2.setAsk((float) 30);
			stock2.setBid((float) 25.5);
			stock2.setDate(stockDate);
			
			stock3.setSymbol("CAAS");
			stock3.setAsk((float) 20);
			stock3.setBid((float) 15.5);
			stock3.setDate(stockDate);
			
			stock4.setSymbol("MOR");
			stock4.setAsk((float) 20);
			stock4.setBid((float) 15.5);
			stock4.setDate(stockDate);

			stock5.setSymbol("SIGLER");
			stock5.setAsk((float) 20);
			stock5.setBid((float) 15.5);
			stock5.setDate(stockDate);
			
			stock6.setSymbol("QUEEN");
			stock6.setAsk((float) 20);
			stock6.setBid((float) 15.5);
			stock6.setDate(stockDate);
		
			myPortfolio.addStock(stock1);
			myPortfolio.addStock(stock2);
			myPortfolio.addStock(stock3);
			//myPortfolio.addStock(stock4);
			//myPortfolio.addStock(stock5);
			//myPortfolio.addStock(stock6);
			myPortfolio.updateBalance(10000);
			myPortfolio.buyStock("PIH", 10);
			myPortfolio.buyStock("AAL", 400);
			myPortfolio.buyStock("CAAS", 40);
			myPortfolio.sellStock("AAL", -1);
			myPortfolio.removeStock("CAAS");
			
			
			return myPortfolio;
		}
		
	}
package il.ac.mta.stock.servlet;

import il.ac.mta.exception.BalanceException;
import il.ac.mta.exception.PortfolioFullException;
import il.ac.mta.exception.StockAlreadyExistsException;
import il.ac.mta.exception.StockNotExistException;
import il.ac.mta.stock.model.Stock;
import il.ac.mta.stock.model.Portfolio;
import il.ac.mta.stock.service.PortfolioService;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//try{
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio;
		try {
			portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlDescription());
			resp.getWriter().println("balance is: "+ portfolio.getBalance()+"<br>");
			resp.getWriter().println("all stocks value is: "+ portfolio.getStocksValue()+"<br>");
			resp.getWriter().println("the total portfolio value is: "+ portfolio.getPortfolioValue()+"<br>");
		} catch (PortfolioFullException | StockAlreadyExistsException
				| StockNotExistException | BalanceException e) {
			// TODO Auto-generated catch block
			resp.getWriter().println(e.getMessage());
		}
	
		
	
	}
}

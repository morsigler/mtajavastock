package il.ac.mta.stock.servlet;

import il.ac.mta.stock.model.Stock;
import il.ac.mta.stock.model.Portfolio;
import il.ac.mta.stock.service.PortfolioService;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortfolioServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		resp.getWriter().println("<b>"+portfolio.getTitle()+"<p></b>");
		for (int i=0; i<portfolio.getPortfolioSize(); i++){
			resp.getWriter().println(portfolio.getStocks()[i].getHtmlDescription());
			resp.getWriter().println("stock quantity is: " +portfolio.getStocksStatus()[i].getStockQuantity()+"<p>");
		}
		resp.getWriter().println("balance is: "+ portfolio.getBalance()+"<br>");
		resp.getWriter().println("all stocks value is: "+ portfolio.getStocksValue()+"<br>");
		resp.getWriter().println("the total portfolio value is: "+ portfolio.getPortfolioValue()+"<br>");
	}
}

package il.ac.mta.stock.servlet;

import il.ac.mta.Stock;
import il.ac.mta.stock.model.portfolio;
import il.ac.mta.stock.service.portfolioService;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortfolioServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		portfolioService portfolioService = new portfolioService();
		portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStocks();
		String rst = new String(portfolio.getHtmlString(stocks));
		resp.getWriter().println(rst);
	}
}

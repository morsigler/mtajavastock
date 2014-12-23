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
		for (int i=0; i<3; i++){
			resp.getWriter().println(portfolio.getStocks()[i].getHtmlDescription());
			
		}
		
		

		/*Portfolio potfolio2 = new Portfolio(portfolio);
		portfolio2.setTitle("Portfolio 2");

		resp.getWriter().println(portfolio.getHtmlString() + "<p>");
		resp.getWriter().println(portfolio2.getHtmlString() + "<p>");
		
		portfolio2.getStocks()[2].setBid(55.55f);
		
		resp.getWriter().println("after changing bid value of portfolio 2" + "</br>");
	
		resp.getWriter().println(portfolio.getHtmlString() + "<p>");
		
		resp.getWriter().println(portfolio2.getHtmlString());*/
	}
}

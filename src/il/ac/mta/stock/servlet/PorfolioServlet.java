/**
 * 
 */
/**
 * @author mor
 *
 */
package il.ac.mta.stock.servlet;

import il.ac.mta.stock.model.portfolio;
import il.ac.mta.stock.service.portfolioService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@SuppressWarnings("serial")
public class PorfolioServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		String result;
		portfolioService portfolioService = new portfolioService();
		portfolio portfolio = portfolioService.getPortfolio();
		result = new String(portfolio.getHtmlString(portfolio));
		resp.getWriter().println(result);
	}
}

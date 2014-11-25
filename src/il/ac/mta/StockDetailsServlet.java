package il.ac.mta;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import il.ac.mta.Stock;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		Stock stock1, stock2, stock3;
		stock1 = new Stock();
		stock2 = new Stock();
		stock3 = new Stock();
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date stockDate = null;
		try {
			stockDate = formatter.parse("11/15/2014");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stock1.setSymbol("PIH");
		stock1.setAsk(12.4);
		stock1.setBid(13.1);
		stock1.setDate(stockDate);

		stock2.setSymbol("AAL");
		stock2.setAsk(5.5);
		stock2.setBid(5.78);
		stock2.setDate(stockDate);
		
		stock3.setSymbol("CAAS");
		stock3.setAsk(31.5);
		stock3.setBid(31.2);
		stock3.setDate(stockDate);
		
		resp.getWriter().println("the stocks details are: <br>");
		resp.getWriter().println(stock1.getHtmlDescription() + "<p>");
		resp.getWriter().println(stock2.getHtmlDescription() + "<p>");
		resp.getWriter().println(stock3.getHtmlDescription());

	
		}
	}


package il.ac.mta.stock.servlet;

import il.ac.mta.dto.PortfolioDto;
import il.ac.mta.dto.PortfolioTotalStatus;
import il.ac.mta.exception.PortfolioFullException;
import il.ac.mta.exception.StockAlreadyExistsException;
import il.ac.mta.stock.model.StockStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortfolioServlet extends AbstractAlgoServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		PortfolioTotalStatus[] totalStatus = null;
		try {
			totalStatus = portfolioService.getPortfolioTotalStatus();
		} catch (StockAlreadyExistsException | PortfolioFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StockStatus[] stockStatusArray = null;
		try {
			stockStatusArray = portfolioService.getPortfolio().getStocks();
		} catch (StockAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortfolioFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<StockStatus> stockStatusList = new ArrayList<>();
		for (StockStatus ss : stockStatusArray) {
			if(ss != null)
				stockStatusList.add(ss);
		}
		
		PortfolioDto pDto = new PortfolioDto();
		try {
			pDto.setTitle(portfolioService.getPortfolio().getTitle());
		} catch (StockAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortfolioFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pDto.setTotalStatus(totalStatus);
		pDto.setStockTable(stockStatusList);
		resp.getWriter().print(withNullObjects().toJson(pDto));
	}
}

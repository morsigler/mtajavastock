package il.ac.mta.exception;

public class StockAlreadyExistsException extends Exception {
	
	public StockAlreadyExistsException(String symbol) {
		super("Stock " + symbol + " already exists!");
	}
}

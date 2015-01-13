package il.ac.mta.exception;

public class StockNotExistException extends Exception {

	public StockNotExistException (String symbol){
		super("the stock "+ symbol +" doesn’t exist");
	}
}

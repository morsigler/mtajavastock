package il.ac.mta.exception;

public class StockNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockNotExistException (String symbol){
		super("the stock "+ symbol +" doesn�t exist");
	}
}

package il.ac.mta.exception;

public class PortfolioFullException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PortfolioFullException() {
		super("you are trying to add more stocks than allowed");
	}

}

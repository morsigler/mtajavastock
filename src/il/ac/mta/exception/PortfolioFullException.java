package il.ac.mta.exception;

public class PortfolioFullException extends Exception{
	
	public PortfolioFullException(){
		super("you are trying to add more stocks than allowed");
	}

}

package il.ac.mta.exception;

public class BalanceException extends Exception {
	
	public BalanceException (){
		super("portfolio balance becomes negative");
	}

}

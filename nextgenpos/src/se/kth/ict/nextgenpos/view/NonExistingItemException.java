package se.kth.ict.nextgenpos.view;

/**
 * 
 * Exception for Controller.
 * @param String with msg. eventually for user
 * @param Exception for logger.
 *
 */

public class NonExistingItemException extends Exception {
	
	public NonExistingItemException(String msg, Exception cause){
		
		super(msg, cause);
	}

}

package se.kth.ict.nextgenpos.model;

/**
 * 
 * Exception for Controller.
 * @param String with msg. eventually for user
 * @param Exception for logger.
 *
 */

public class NonExistingItemException extends Exception {
	
	public NonExistingItemException(String msg){
		
		super(msg);
	}

}

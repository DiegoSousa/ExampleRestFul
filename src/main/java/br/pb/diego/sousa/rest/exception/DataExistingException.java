package br.pb.diego.sousa.rest.exception;

/**
 * Exception for existing data.
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since Apr 22, 2013
 * 
 */

@SuppressWarnings("serial")
public class DataExistingException extends Exception {

	public DataExistingException(String message) {
		super(message);
	}

}

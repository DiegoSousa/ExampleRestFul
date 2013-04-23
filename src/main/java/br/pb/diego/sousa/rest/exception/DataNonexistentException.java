package br.pb.diego.sousa.rest.exception;

/**
 * Exception for nonexistent data.
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since Apr 22, 2013
 * 
 */
@SuppressWarnings("serial")
public class DataNonexistentException extends Exception {

	public DataNonexistentException(String message) {
		super(message);
	}
}

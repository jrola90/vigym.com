package pl.jrola.java.www.vigym.model.dao.exceptions;

public class GetUserException extends Exception {

	private static final long serialVersionUID = 2412400445869071893L;

	public GetUserException(String msg) {
		super(msg);
	}
	
	public GetUserException(Exception e) {
		super(e);
	}
	
}
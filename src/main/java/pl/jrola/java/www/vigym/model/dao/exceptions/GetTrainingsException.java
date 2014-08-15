package pl.jrola.java.www.vigym.model.dao.exceptions;

public class GetTrainingsException extends Exception {

	private static final long serialVersionUID = 8560746389828249000L;

	public GetTrainingsException(String msg) {
		super(msg);
	}
	
	public GetTrainingsException(Exception e) {
		super(e);
	}
	
}

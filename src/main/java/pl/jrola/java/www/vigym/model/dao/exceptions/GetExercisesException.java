package pl.jrola.java.www.vigym.model.dao.exceptions;

public class GetExercisesException extends Exception {

	private static final long serialVersionUID = -9073997287907283626L;

	public GetExercisesException(String msg) {
		super(msg);
	}
	
	public GetExercisesException(Exception e) {
		super(e);
	}
	
}
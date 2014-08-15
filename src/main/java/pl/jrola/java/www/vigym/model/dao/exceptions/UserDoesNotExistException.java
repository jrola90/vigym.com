package pl.jrola.java.www.vigym.model.dao.exceptions;

import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

public class UserDoesNotExistException extends Exception {

	private static final long serialVersionUID = 9111280204760380446L;

	public UserDoesNotExistException(String id) {
		super(JSFUtils.getMessage("error_wrong_user_id2",
				new String[] { "id" }, new String[] { id }));
	}

}

package pl.jrola.java.www.vigym.model.dao;

import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.model.entities.dao.exceptions.GetUserException;

public class UserDAOImpl implements UsersDAO {

	@Override
	public UserEntity getUser(String nickname, String password)
			throws GetUserException {
		return null;
	}

}
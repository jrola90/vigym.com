package pl.jrola.java.www.vigym.model.dao;

import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

public interface UsersDAO {
	UserEntity getUser(String nickname, String password) throws GetUserException;
}
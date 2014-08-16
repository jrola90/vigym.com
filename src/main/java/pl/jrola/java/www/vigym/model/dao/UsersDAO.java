package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

public interface UsersDAO {
	UserEntity getUser(String nickname, String password) throws GetUserException;
	UserEntity getUser(Long id) throws GetUserException;
	UserEntity getUser(String id) throws GetUserException;
	List<UserEntity> getUsers() throws GetUserException;
}

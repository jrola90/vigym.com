package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.UsersDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

@ManagedBean (name="userListBean")
@RequestScoped
public class UserListBean implements Serializable {

	private static final long serialVersionUID = -8381452909289894188L;

	private UsersDAO usersDAO = DAOFactory.createUsersDAO();
	private String errorMessage;
	
	private List<UserEntity> userList;
	
	
	public UserListBean() {
		try {
			userList = usersDAO.getUsers();
		} catch (GetUserException e) {
			errorMessage = e.getMessage();
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}
}
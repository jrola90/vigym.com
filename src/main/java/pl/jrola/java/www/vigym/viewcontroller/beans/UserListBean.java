package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.UsersDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

@ManagedBean (name="userListBean")
@ViewScoped
public class UserListBean implements Serializable {

	private static final long serialVersionUID = -8381452909289894188L;

	private UsersDAO usersDAO;
	private String errorMessage;
	
	private List<UserEntity> userList;
	private UserEntity selectedUser;
	
	public UserListBean() {

	}

	@PostConstruct
	public void postConstruct() {
		try {
			usersDAO = DAOFactory.createUsersDAO();
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

	public UserEntity getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}
}
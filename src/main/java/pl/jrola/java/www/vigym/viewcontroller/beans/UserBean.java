package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.UsersDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1133776969885921779L;

	private UserEntity userEntity;

	private String login;
	private String password;
	private String email;

	private String errorMessage;
	private boolean isAuth = false;

	public UserBean() {

	}

	@PostConstruct
	public void postConstruct() {

	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public String getEmail() {
		if (userEntity != null)
			email = userEntity.getEmail();
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void doLogin(ActionEvent event) {

		try {
			UsersDAO userDAO = DAOFactory.createUsersDAO();
			userEntity = userDAO.getUser(login, password);
			if (userEntity != null) {
				isAuth = true;
				errorMessage = null;
			} else {
				errorMessage = JSFUtils.getMessage("incorrect_login_or_password");
			}

		} catch (GetUserException e) {
			errorMessage = e.getMessage();
		}

	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public void doLogout(ActionEvent event) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("userBean");
	}
}
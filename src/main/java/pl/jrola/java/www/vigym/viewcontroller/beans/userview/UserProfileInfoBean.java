package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.UsersDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userProfileInfoBean")
@ViewScoped
public class UserProfileInfoBean implements Serializable {
	private static final long serialVersionUID = -1344710323318237421L;

	private UserEntity userEntity;
	private String errorMessage;

	public UserProfileInfoBean() {

	}

	@PostConstruct
	public void postConstruct() {
		Object userId = null;
		try {
			UsersDAO usersDAO = DAOFactory.createUsersDAO();
			userId = JSFUtils.getRequestParameter("id");
			if (userId != null) {
				userEntity = usersDAO.getUser(userId.toString());
			} else {
				errorMessage = JSFUtils.getMessage("error_wrong_user_id");
			}
		} catch (NumberFormatException e) {
			errorMessage = JSFUtils.getMessage("error_wrong_user_id");
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
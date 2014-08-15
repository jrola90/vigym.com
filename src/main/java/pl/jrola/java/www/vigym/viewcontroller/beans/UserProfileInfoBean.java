package pl.jrola.java.www.vigym.viewcontroller.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.UsersDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userProfileInfoBean")
@RequestScoped
public class UserProfileInfoBean {

	private UsersDAO usersDAO = DAOFactory.createUsersDAO();
	private UserEntity userEntity;

	private String errorMessage;

	public UserProfileInfoBean() {

		Object userId = null;
		try {
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
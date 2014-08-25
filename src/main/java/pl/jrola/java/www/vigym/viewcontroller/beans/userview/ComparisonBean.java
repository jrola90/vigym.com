package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.viewcontroller.beans.UserBean;

@ManagedBean(name = "comparisonBean")
@ViewScoped
public class ComparisonBean implements Serializable {

	private static final long serialVersionUID = 9140055156488461543L;

	@ManagedProperty(value = "#{userBean}")
	private UserBean loggedUser;

	@ManagedProperty(value = "#{userExercisesBean}")
	private UserExercisesBean userExercisesBean;

	@ManagedProperty(value = "#{userProfileInfoBean}")
	private UserProfileInfoBean userProfileInfoBean;

	private ComparisonModel comparisonModel;

	private boolean isAvailable = false;

	public ComparisonBean() {

	}

	@PostConstruct
	public void postConstruct() {
		UserEntity loggedUserEntity = this.getLoggedUserEntity();
		UserEntity viewedUserEntity = this.getCurrentlyViewedUserEntity();
		if (loggedUserEntity != null && viewedUserEntity != null
				&& loggedUserEntity.equals(viewedUserEntity) == false) {
			this.isAvailable = true;
			this.comparisonModel = new ComparisonModel(loggedUserEntity,
					viewedUserEntity);
		}
	}

	private UserEntity getLoggedUserEntity() {
		if (loggedUser != null) {
			return loggedUser.getUserEntity();
		}
		return null;
	}

	private UserEntity getCurrentlyViewedUserEntity() {
		if (userProfileInfoBean != null) {
			return userProfileInfoBean.getUserEntity();
		}
		return null;
	}

	public UserBean getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(UserBean loggedUser) {
		this.loggedUser = loggedUser;
	}

	public UserExercisesBean getUserExercisesBean() {
		return userExercisesBean;
	}

	public void setUserExercisesBean(UserExercisesBean userExercisesBean) {
		this.userExercisesBean = userExercisesBean;
	}

	public UserProfileInfoBean getUserProfileInfoBean() {
		return userProfileInfoBean;
	}

	public void setUserProfileInfoBean(UserProfileInfoBean userProfileInfoBean) {
		this.userProfileInfoBean = userProfileInfoBean;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public ComparisonModel getComparisonModel() {
		return comparisonModel;
	}

	public void setComparisonModel(ComparisonModel comparisonModel) {
		this.comparisonModel = comparisonModel;
	}

}
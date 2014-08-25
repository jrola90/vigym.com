package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.TrainingsDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;
import pl.jrola.java.www.vigym.model.entities.UserEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userExercisesBean")
@ViewScoped
public class UserExercisesBean implements Serializable {

	private static final long serialVersionUID = -837891465485933594L;

	private ExercisesModel exercisesModel;
	private TrainingsByExerciseBean selectedTrainingGroup;
	private UserEntity currentlyViewedUser;
	
	private String errorMessage;

	public UserExercisesBean() {

	}

	@PostConstruct
	public void postConstruct() {
		Object userId = null;
		try {
			userId = JSFUtils.getRequestParameter("id");
			if (userId != null) {
				
				TrainingsDAO trainingsDAO = DAOFactory.createTrainingsDAO();
				List<TrainingEntity> trainings = trainingsDAO
						.getTrainingsByUserId(userId.toString());
				this.exercisesModel = new ExercisesModel();
				for (TrainingEntity training : trainings) {
					this.exercisesModel.addTrainingToGroup(training);
				}

				this.exercisesModel.calcValues();

			} else {
				errorMessage = JSFUtils.getMessage("error_wrong_user_id");
			}
		} catch (NumberFormatException e) {
			errorMessage = JSFUtils.getMessage("error_wrong_user_id");
		} catch (GetTrainingsException e) {
			errorMessage = e.getMessage();
		}
	}



	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public TrainingsByExerciseBean getSelectedTrainingGroup() {
		return selectedTrainingGroup;
	}

	public void setSelectedTrainingGroup(
			TrainingsByExerciseBean selectedTrainingGroup) {
		this.selectedTrainingGroup = selectedTrainingGroup;
	}

	public UserEntity getCurrentlyViewedUser() {
		return currentlyViewedUser;
	}

	public void setCurrentlyViewedUser(UserEntity currentlyViewedUser) {
		this.currentlyViewedUser = currentlyViewedUser;
	}

	public ExercisesModel getExercisesModel() {
		return exercisesModel;
	}

	public void setExercisesModel(ExercisesModel exercisesModel) {
		this.exercisesModel = exercisesModel;
	}

}
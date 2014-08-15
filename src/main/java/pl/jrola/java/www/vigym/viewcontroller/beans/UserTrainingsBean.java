package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.TrainingsDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userTrainingsBean")
@RequestScoped
public class UserTrainingsBean implements Serializable {

	private static final long serialVersionUID = -3421779712099730373L;

	private TrainingsDAO trainingsDAO = DAOFactory.createTrainingsDAO();

	private Map<ExerciseEntity, TrainingList> trainings = new LinkedHashMap<ExerciseEntity, TrainingList>();

	private String errorMessage;

	public UserTrainingsBean() {

		Object userId = null;
		try {
			userId = JSFUtils.getRequestParameter("id");

			if (userId != null) {
				List<TrainingEntity> trainingList = trainingsDAO
						.getTrainingsByUserId(userId.toString());

				this.groupTrainings(trainingList);

			} else {
				errorMessage = JSFUtils.getMessage("error_wrong_user_id");
			}

		} catch (NumberFormatException e) {
			errorMessage = JSFUtils.getMessage("error_wrong_user_id");
		} catch (GetTrainingsException e) {
			errorMessage = e.getMessage();
		}

	}

	public Map<ExerciseEntity, TrainingList> getTrainings() {
		return trainings;
	}

	public void setTrainings(Map<ExerciseEntity, TrainingList> trainings) {
		this.trainings = trainings;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private void groupTrainings(List<TrainingEntity> trainingList) {

		for (TrainingEntity training : trainingList) {
			ExerciseEntity exercise = training.getExercise();
			if (trainings.containsKey(exercise) == false)
				trainings.put(exercise, new TrainingList());
			TrainingList list = trainings.get(exercise);
			list.addTraining(training);
		}

	}

}
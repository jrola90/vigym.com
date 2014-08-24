package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.TrainingsDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "userExercisesBean")
@ViewScoped
public class UserExercisesBean implements Serializable {

	private static final long serialVersionUID = -837891465485933594L;

	private Map<ExerciseEntity, TrainingsByExerciseBean> exercises = new LinkedHashMap<ExerciseEntity, TrainingsByExerciseBean>();
	private TrainingsByExerciseBean selectedTrainingGroup;
	
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
				for (TrainingEntity training : trainings) {
					this.addTrainingToGroup(training);
				}

				this.calcValues();

			} else {
				errorMessage = JSFUtils.getMessage("error_wrong_user_id");
			}
		} catch (NumberFormatException e) {
			errorMessage = JSFUtils.getMessage("error_wrong_user_id");
		} catch (GetTrainingsException e) {
			errorMessage = e.getMessage();
		}
	}

	private void calcValues() {
		Iterator iter = exercises.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<ExerciseEntity, TrainingsByExerciseBean> entry = (Entry<ExerciseEntity, TrainingsByExerciseBean>) iter
					.next();
			entry.getValue().calcValues();
		}
	}

	private void addTrainingToGroup(TrainingEntity training) {
		ExerciseEntity exercise = training.getExercise();
		TrainingsByExerciseBean trainingGroup = this.exercises.get(exercise);
		if (trainingGroup == null) {
			trainingGroup = new TrainingsByExerciseBean();
			this.exercises.put(exercise, trainingGroup);
		}
		trainingGroup.addTraining(training);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<ExerciseEntity, TrainingsByExerciseBean> getExercises() {
		return exercises;
	}

	public TrainingsByExerciseBean getSelectedTrainingGroup() {
		return selectedTrainingGroup;
	}

	public void setSelectedTrainingGroup(
			TrainingsByExerciseBean selectedTrainingGroup) {
		this.selectedTrainingGroup = selectedTrainingGroup;
	}

}
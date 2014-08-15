package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

public class TrainingList implements Serializable {

	private static final long serialVersionUID = -3018745231274291909L;

	private List<TrainingEntity> trainings = new ArrayList<TrainingEntity>();
	
	public TrainingList() {

	}
	
	public void addTraining(TrainingEntity training) {
		trainings.add(training);
	}
	
	public void removeTraining(TrainingEntity training) {
		trainings.remove(training);
	}
	
	public void removeAllTrainings() {
		trainings.clear();
	}

	public List<TrainingEntity> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<TrainingEntity> trainings) {
		this.trainings = trainings;
	}
}
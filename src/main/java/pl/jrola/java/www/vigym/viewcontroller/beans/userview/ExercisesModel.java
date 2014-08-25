package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

public class ExercisesModel implements Serializable {

	private static final long serialVersionUID = -2522118213224829526L;

	private Map<ExerciseEntity, TrainingsByExerciseBean> exercises = new LinkedHashMap<ExerciseEntity, TrainingsByExerciseBean>();
	
	public ExercisesModel() {

	}

	public Map<ExerciseEntity, TrainingsByExerciseBean> getExercises() {
		return exercises;
	}
	
	public void calcValues() {
		Iterator iter = exercises.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<ExerciseEntity, TrainingsByExerciseBean> entry = (Entry<ExerciseEntity, TrainingsByExerciseBean>) iter
					.next();
			entry.getValue().calcValues();
		}
	}

	public void addTrainingToGroup(TrainingEntity training) {
		ExerciseEntity exercise = training.getExercise();
		TrainingsByExerciseBean trainingGroup = this.exercises.get(exercise);
		if (trainingGroup == null) {
			trainingGroup = new TrainingsByExerciseBean();
			this.exercises.put(exercise, trainingGroup);
		}
		trainingGroup.addTraining(training);
	}
	
	public boolean containsExercise(ExerciseEntity exercise) {
		return this.exercises.containsKey(exercise);
	}
	
	public Set<ExerciseEntity> getExerciseSet() {
		return exercises.keySet(); 
	}
	
	public TrainingsByExerciseBean getTrainingsStats(ExerciseEntity exercise) {
		return exercises.get(exercise);
	}
	
}
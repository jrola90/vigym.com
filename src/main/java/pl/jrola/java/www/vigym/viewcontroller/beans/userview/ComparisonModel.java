package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

public class ComparisonModel implements Serializable {

	private static final long serialVersionUID = 558877851153141893L;

	private ExercisesModel exercisesModel1;
	private ExercisesModel exercisesModel2;

	private List<ExerciseEntity> commonExercises;
	private Double score;

	public ComparisonModel() {

	}

	public ComparisonModel(UserEntity user1, UserEntity user2) {
		this.exercisesModel1 = this.createExercisesModel(user1);
		this.exercisesModel2 = this.createExercisesModel(user2);
		this.commonExercises = this.createCommonExercises();
		this.score = this.calcScore();
	}

	private ExercisesModel createExercisesModel(UserEntity userEntity) {
		ExercisesModel exercisesModel = new ExercisesModel();
		Set<TrainingEntity> trainings = userEntity.getTrainings();
		for (TrainingEntity training : trainings) {
			exercisesModel.addTrainingToGroup(training);
		}
		exercisesModel.calcValues();
		return exercisesModel;
	}

	private List<ExerciseEntity> createCommonExercises() {
		List<ExerciseEntity> exercises = new ArrayList<ExerciseEntity>();
		for (ExerciseEntity exercise : this.exercisesModel1.getExerciseSet()) {
			if (this.exercisesModel2.containsExercise(exercise)) {
				exercises.add(exercise);
			}
		}
		return exercises;
	}

	private Double calcScore() {
		Double score = 0.;

		for (ExerciseEntity exercise : commonExercises) {
			double val1 = this.exercisesModel1.getTrainingsStats(exercise)
					.getMaxSingleValue();
			double val2 = this.exercisesModel2.getTrainingsStats(exercise)
					.getMaxSingleValue();
			score += (val1 - val2) / (val1 + val2);
		}

		return score;
	}

	public Double getComparison(ExerciseEntity exercise) {
		Double score = 0.;

		double val1 = this.exercisesModel1.getTrainingsStats(exercise)
				.getMaxSingleValue();
		double val2 = this.exercisesModel2.getTrainingsStats(exercise)
				.getMaxSingleValue();
		score += (val1 - val2) / (val1 + val2);

		return score;
	}

	public ExercisesModel getExercisesModel1() {
		return exercisesModel1;
	}

	public void setExercisesModel1(ExercisesModel exercisesModel1) {
		this.exercisesModel1 = exercisesModel1;
	}

	public ExercisesModel getExercisesModel2() {
		return exercisesModel2;
	}

	public void setExercisesModel2(ExercisesModel exercisesModel2) {
		this.exercisesModel2 = exercisesModel2;
	}

	public List<ExerciseEntity> getCommonExercises() {
		return commonExercises;
	}

	public void setCommonExercises(List<ExerciseEntity> commonExercises) {
		this.commonExercises = commonExercises;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

public class TrainingsByExerciseBean implements Serializable {

	private static final long serialVersionUID = -7447440775602349885L;

	private List<TrainingEntity> trainings = new ArrayList<TrainingEntity>();

	private Double maxSingleValue;
	private Double maxTotalValue;
	private Double avgSingleValue;
	private Double avgTotalValue;
	private TrainingEntity lastTraining;

	public TrainingsByExerciseBean() {

	}

	public void calcValues() {
		this.calcMaxSingleValue();
		this.calcMaxTotalValue();
		this.calcAvgSingleValue();
		this.calcAvgTotalValue();
		this.calcLastTraining();
	}

	private void calcMaxSingleValue() {
		TrainingEntity training = Collections.max(this.trainings,
				new Comparator<TrainingEntity>() {
					@Override
					public int compare(TrainingEntity o1, TrainingEntity o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
				});

		this.maxSingleValue = training.getValue();
	}

	private void calcMaxTotalValue() {
		TrainingEntity training = Collections.max(this.trainings,
				new Comparator<TrainingEntity>() {
					@Override
					public int compare(TrainingEntity o1, TrainingEntity o2) {
						Double o1TotalValue = o1.getValue() * o1.getCount();
						Double o2TotalValue = o2.getValue() * o2.getCount();
						return o1TotalValue.compareTo(o2TotalValue);
					}
				});

		this.maxTotalValue = training.getValue() * training.getCount();
	}

	private void calcAvgSingleValue() {
		int size = trainings.size();
		double avg = 0;

		for (TrainingEntity training : trainings) {
			avg += training.getValue();
		}
		this.avgSingleValue = avg / size;
	}

	private void calcAvgTotalValue() {
		int size = trainings.size();
		double avg = 0;

		for (TrainingEntity training : trainings) {
			avg += (training.getValue() * training.getCount());
		}
		this.avgTotalValue = avg / size;
	}

	private void calcLastTraining() {
		this.lastTraining = Collections.max(this.trainings);
	}

	public void addTraining(TrainingEntity training) {
		trainings.add(training);
	}

	public List<TrainingEntity> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<TrainingEntity> trainings) {
		this.trainings = trainings;
	}

	public Double getMaxValueSingle() {
		return maxSingleValue;
	}

	public void setMaxValueSingle(Double maxValueSingle) {
		this.maxSingleValue = maxValueSingle;
	}

	public Double getMaxValueTotal() {
		return maxTotalValue;
	}

	public void setMaxValueTotal(Double maxValueTotal) {
		this.maxTotalValue = maxValueTotal;
	}

	public Double getMaxSingleValue() {
		return maxSingleValue;
	}

	public void setMaxSingleValue(Double maxSingleValue) {
		this.maxSingleValue = maxSingleValue;
	}

	public Double getMaxTotalValue() {
		return maxTotalValue;
	}

	public void setMaxTotalValue(Double maxTotalValue) {
		this.maxTotalValue = maxTotalValue;
	}

	public Double getAvgSingleValue() {
		return avgSingleValue;
	}

	public void setAvgSingleValue(Double avgSingleValue) {
		this.avgSingleValue = avgSingleValue;
	}

	public Double getAvgTotalValue() {
		return avgTotalValue;
	}

	public void setAvgTotalValue(Double avgTotalValue) {
		this.avgTotalValue = avgTotalValue;
	}

	public TrainingEntity getLastTraining() {
		return lastTraining;
	}

	public void setLastTraining(TrainingEntity lastTraining) {
		this.lastTraining = lastTraining;
	}

}
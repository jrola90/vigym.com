package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	public Double getMaxSingle() {
		if (trainings.size() > 0) {
			return Collections.max(trainings, new Comparator<TrainingEntity>() {
				@Override
				public int compare(TrainingEntity o1, TrainingEntity o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
			}).getValue();
		}
		return 0.;
	}

	public Double getMaxTotal() {
		if (trainings.size() > 0) {
			TrainingEntity training = Collections.max(trainings,
					new Comparator<TrainingEntity>() {
						@Override
						public int compare(TrainingEntity o1, TrainingEntity o2) {
							Double o1TotalValue = o1.getCount() * o1.getValue();
							Double o2TotalValue = o2.getCount() * o2.getValue();
							return o1TotalValue.compareTo(o2TotalValue);
						}
					});
			return training.getCount() * training.getValue();
		}
		return 0.;
	}

	public Double getAvgSingle() {
		if (trainings.size() > 0) {
			double avg = 0;
			for (TrainingEntity training : trainings) {
				avg += training.getValue();
			}
			return avg / trainings.size();
		}
		return 0.;
	}

	public Double getAvgTotal() {
		if (trainings.size() > 0) {
			double avg = 0;
			for (TrainingEntity training : trainings) {
				avg += (training.getValue() * training.getCount());
			}
			return avg / trainings.size();
		}
		return 0.;
	}

	public TrainingEntity getLastTraining() {
		if (trainings.size() > 0) {
			return Collections.max(trainings);
		}
		return null;
	}
}
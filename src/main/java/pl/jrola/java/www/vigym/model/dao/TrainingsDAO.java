package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

public interface TrainingsDAO {
	List<TrainingEntity> getTrainingsOrderedByDateDesc() throws GetTrainingsException;
	List<TrainingEntity> getTrainingsByUserId(Long id) throws GetTrainingsException;
	List<TrainingEntity> getTrainingsByUserId(String id) throws GetTrainingsException;
}

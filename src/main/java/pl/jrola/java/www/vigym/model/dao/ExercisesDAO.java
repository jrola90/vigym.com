package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import pl.jrola.java.www.vigym.model.dao.exceptions.GetExercisesException;
import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;

public interface ExercisesDAO {
	List<ExerciseEntity> getExerciseList() throws GetExercisesException;
}

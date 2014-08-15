package pl.jrola.java.www.vigym.model.dao;

public abstract class DAOFactory {

	public static UsersDAO createUsersDAO() {
		return new UsersDAOImpl(); 
	}
	
	public static ExercisesDAO createExercisesDAO() {
		return new ExercisesDAOImpl();
	}
	
	public static TrainingsDAO createTrainingsDAO() {
		return new TrainingsDAOImpl();
	}
	
}

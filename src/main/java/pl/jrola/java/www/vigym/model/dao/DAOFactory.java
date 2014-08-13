package pl.jrola.java.www.vigym.model.dao;

public abstract class DAOFactory {

	public static UsersDAO createUsersDAO() {
		return new UserDAOImpl(); 
	}
	
}

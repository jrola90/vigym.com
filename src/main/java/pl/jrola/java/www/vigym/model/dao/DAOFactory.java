package pl.jrola.java.www.vigym.model.dao;

public abstract class DAOFactory implements DAOFactoryInterface {

	public UsersDAO createUsersDAO() {
		return new UserDAOImpl(); 
	}
	
}

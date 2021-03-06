package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.jrola.java.www.vigym.model.HibernateUtils;
import pl.jrola.java.www.vigym.model.Utils;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetUserException;
import pl.jrola.java.www.vigym.model.dao.exceptions.UserDoesNotExistException;
import pl.jrola.java.www.vigym.model.entities.UserEntity;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public UserEntity getUser(String nickname, String password)
			throws GetUserException {

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from UserEntity where upper(nickname) = :username AND upper(password) = :password");
			query.setString("username", nickname.toUpperCase());
			query.setString("password", Utils.generateSHA1Hash(password)
					.toUpperCase());
			List<UserEntity> list = query.list();

			if (list.size() == 1)
				return list.get(0);

			return null;

		} catch (Exception e) {
			Utils.logError(e);
			throw new GetUserException(e);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public UserEntity getUser(Long id) throws GetUserException {

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from UserEntity where user_id = :id");
			query.setLong("id", id);
			List<UserEntity> list = query.list();

			if (list.size() == 1)
				return list.get(0);

			throw new UserDoesNotExistException(id.toString());

		} catch (Exception e) {
			Utils.logError(e);
			throw new GetUserException(e);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public UserEntity getUser(String id) throws GetUserException {
		Long longId = Long.parseLong(id);
		return this.getUser(longId);
	}

	@Override
	public List<UserEntity> getUsers() throws GetUserException {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from UserEntity order by id");
			List<UserEntity> list = query.list();

			return list;
			
		} catch (Exception e) {
			Utils.logError(e);
			throw new GetUserException(e);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}
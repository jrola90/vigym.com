package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import pl.jrola.java.www.vigym.model.Utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.jrola.java.www.vigym.model.HibernateUtils;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

public class TrainingsDAOImpl implements TrainingsDAO {

	@Override
	public List<TrainingEntity> getTrainingsOrderedByDateDesc()
			throws GetTrainingsException {

		SessionFactory sessionFactory = null;
		Session session = null;

		try {

			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from TrainingEntity order by date desc");

			List<TrainingEntity> list = query.list();

			return list;

		} catch (Exception e) {
			Utils.logError(e);
			throw new GetTrainingsException(e);
		} finally {
			if (session != null && session.isOpen())
				session.close();

		}

	}

}
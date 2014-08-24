package pl.jrola.java.www.vigym.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.jrola.java.www.vigym.model.HibernateUtils;
import pl.jrola.java.www.vigym.model.Utils;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetExercisesException;
import pl.jrola.java.www.vigym.model.entities.ExerciseEntity;

public class ExercisesDAOImpl implements ExercisesDAO {

	@Override
	public List<ExerciseEntity> getExerciseList() throws GetExercisesException {

		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();

			Query query = session.createQuery("from ExerciseEntity");
			List<ExerciseEntity> exerciseList = query.list();

			return exerciseList;

		} catch (Exception e) {
			Utils.logError(e);
			throw new GetExercisesException(e);
		}

	}

}
package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.TrainingsDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

@ManagedBean(name="trainingsBean")
@RequestScoped
public class TrainingsBean implements Serializable {

	private static final long serialVersionUID = 6198339254053071175L;

	private TrainingsDAO trainingsDAO = DAOFactory.createTrainingsDAO();
	
	private List<TrainingEntity> trainings;

	public TrainingsBean() {
	
		try {
			trainings = trainingsDAO.getTrainingsOrderedByDateDesc();
		} catch (GetTrainingsException e) {
			trainings = new ArrayList<TrainingEntity>();
			// TODO: display error message
		}
		
	}

	public List<TrainingEntity> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<TrainingEntity> trainings) {
		this.trainings = trainings;
	}
}
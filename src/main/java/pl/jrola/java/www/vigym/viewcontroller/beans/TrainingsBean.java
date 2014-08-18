package pl.jrola.java.www.vigym.viewcontroller.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import pl.jrola.java.www.vigym.model.dao.DAOFactory;
import pl.jrola.java.www.vigym.model.dao.TrainingsDAO;
import pl.jrola.java.www.vigym.model.dao.exceptions.GetTrainingsException;
import pl.jrola.java.www.vigym.model.entities.TrainingEntity;

@ManagedBean(name = "trainingsBean")
@ViewScoped
public class TrainingsBean implements Serializable {

	private static final long serialVersionUID = 6198339254053071175L;

	private TrainingsDAO trainingsDAO;

	private List<TrainingEntity> trainings;

	private String errorMessage;
	
	public TrainingsBean() {

	}

	@PostConstruct
	public void postConstruct() {
		try {
			trainingsDAO = DAOFactory.createTrainingsDAO();
			trainings = trainingsDAO.getTrainingsOrderedByDateDesc();
		} catch (GetTrainingsException e) {
			trainings = new ArrayList<TrainingEntity>();
			this.errorMessage = e.getMessage();
		}
	}

	public List<TrainingEntity> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<TrainingEntity> trainings) {
		this.trainings = trainings;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
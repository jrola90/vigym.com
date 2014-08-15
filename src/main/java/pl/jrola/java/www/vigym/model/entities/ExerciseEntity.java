package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.jrola.java.www.vigym.model.DbUtils;

@Entity
@Table (name=DbUtils.EXERCISES_TABLE.TABLE_NAME)
public class ExerciseEntity implements Serializable {

	private static final long serialVersionUID = -7540409414928591741L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=DbUtils.EXERCISES_TABLE.ID)
	private Long id;
	
	@Column(name=DbUtils.EXERCISES_TABLE.NAME)
	private String name;
	
	@Column(name=DbUtils.EXERCISES_TABLE.DESC)
	private String desc;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exercise")
	private Set<TrainingEntity> trainings = new HashSet<TrainingEntity>();
	

	public ExerciseEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Set<TrainingEntity> getTrainings() {
		return trainings;
	}
	
	public void setTrainings(Set<TrainingEntity> trainings) {
		this.trainings = trainings;
	}

}
package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.jrola.java.www.vigym.model.DbUtils;

@Entity
@Table(name=DbUtils.TRAININGS_TABLE.TABLE_NAME)
public class TrainingEntity implements Serializable {

	private static final long serialVersionUID = 9221724729175009214L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=DbUtils.TRAININGS_TABLE.ID)
	private Long id;
	
	@Column(name=DbUtils.TRAININGS_TABLE.DATE)
	private Date date;
	
	@Column(name=DbUtils.TRAININGS_TABLE.VALUE)
	private Double value;
	
	@Column(name=DbUtils.TRAININGS_TABLE.COUNT)
	private Integer count;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name=DbUtils.TRAININGS_TABLE.EXERCISE)
	private ExerciseEntity exercise;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = DbUtils.TRAININGS_TABLE.USER)
	private UserEntity user;
	
	@Column(name=DbUtils.TRAININGS_TABLE.MOBILE_ID)
	private Long mobileId;
	
	public TrainingEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ExerciseEntity getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseEntity exercise) {
		this.exercise = exercise;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Long getMobileId() {
		return mobileId;
	}

	public void setMobileId(Long mobileId) {
		this.mobileId = mobileId;
	}

}
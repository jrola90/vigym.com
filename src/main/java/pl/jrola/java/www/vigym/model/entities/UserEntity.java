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
@Table(name=DbUtils.USERS_TABLE.TABLE_NAME)
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -4274899788009303050L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=DbUtils.USERS_TABLE.ID)
	private Long id;
	
	@Column(name=DbUtils.USERS_TABLE.NICKNAME)
	private String nickname;
	
	@Column(name=DbUtils.USERS_TABLE.PASSWORD)
	private String password;
	
	@Column(name=DbUtils.USERS_TABLE.EMAIL)
	private String email;
	
	@Column(name=DbUtils.USERS_TABLE.MOBILE_ID)
	private Long mobileId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<TrainingEntity> trainings = new HashSet<TrainingEntity>();
	
	public UserEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileId() {
		return mobileId;
	}

	public void setMobileId(Long mobileId) {
		this.mobileId = mobileId;
	}

	public Set<TrainingEntity> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<TrainingEntity> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", nickname=" + nickname
				+ ", password=" + password + ", email=" + email + ", mobileId="
				+ mobileId + ", trainings=" + trainings + "]";
	}
	
}
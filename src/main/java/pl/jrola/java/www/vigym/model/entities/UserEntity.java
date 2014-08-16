package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;
import java.util.Collections;
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
@Table(name = DbUtils.USERS_TABLE.TABLE_NAME)
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -4274899788009303050L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DbUtils.USERS_TABLE.ID)
	private Long id;

	@Column(name = DbUtils.USERS_TABLE.NICKNAME)
	private String nickname;

	@Column(name = DbUtils.USERS_TABLE.PASSWORD)
	private String password;

	@Column(name = DbUtils.USERS_TABLE.EMAIL)
	private String email;

	@Column(name = DbUtils.USERS_TABLE.MOBILE_ID)
	private Long mobileId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<TrainingEntity> trainings = new HashSet<TrainingEntity>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<ProfileInfoEntity> profileInfoSet = new HashSet<ProfileInfoEntity>();

	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String nickname, String password, String email,
			Long mobileId) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.mobileId = mobileId;
	}

	public UserEntity(Long id, String nickname, String password, String email,
			Long mobileId, Set<TrainingEntity> trainings,
			Set<ProfileInfoEntity> profileInfoSet) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.mobileId = mobileId;
		this.trainings = trainings;
		this.profileInfoSet = profileInfoSet;
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

	public Set<ProfileInfoEntity> getProfileInfoSet() {
		return profileInfoSet;
	}

	public void setProfileInfoSet(Set<ProfileInfoEntity> profileInfoSet) {
		this.profileInfoSet = profileInfoSet;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof UserEntity && ((UserEntity) obj).email.equals(email)
				&& ((UserEntity) obj).id.equals(id)
				&& ((UserEntity) obj).nickname.equals(nickname)
				&& ((UserEntity) obj).password.equals(password)
				&& ((UserEntity) obj).mobileId.equals(mobileId))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	public TrainingEntity getLastTraining() {
		return Collections.max(trainings);
	}

}
package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.jrola.java.www.vigym.model.DbUtils;

@Entity
@Table(name = DbUtils.PROFILE_INFO_TABLE.TABLE_NAME)
public class ProfileInfoEntity implements Serializable {

	private static final long serialVersionUID = -5786134876596833297L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DbUtils.PROFILE_INFO_TABLE.ID)
	private Long id;

	@Column(name = DbUtils.PROFILE_INFO_TABLE.NAME)
	private String name;

	@Column(name = DbUtils.PROFILE_INFO_TABLE.DESC)
	private String desc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = DbUtils.PROFILE_INFO_TABLE.USER)
	private UserEntity user;

	@Column(name = DbUtils.PROFILE_INFO_TABLE.MOBILE_ID)
	private Long mobileId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profileInfo")
	private Set<ProfileInfoValueEntity> profileInfoValues = new HashSet<ProfileInfoValueEntity>();

	public ProfileInfoEntity() {

	}

	public ProfileInfoEntity(Long id, String name, String desc,
			UserEntity user, Long mobileId) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.user = user;
		this.mobileId = mobileId;
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

	public Set<ProfileInfoValueEntity> getProfileInfoValues() {
		return profileInfoValues;
	}

	public void setProfileInfoValues(
			Set<ProfileInfoValueEntity> profileInfoValues) {
		this.profileInfoValues = profileInfoValues;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProfileInfoEntity
				&& ((ProfileInfoEntity) obj).id.equals(id)
				&& ((ProfileInfoEntity) obj).name.equals(name)
				&& ((ProfileInfoEntity) obj).desc.equals(desc)
				&& ((ProfileInfoEntity) obj).user.equals(user)
				&& ((ProfileInfoEntity) obj).mobileId.equals(mobileId))
			return true;
		return false;
	}

	public Date getLastDate() {
		if (profileInfoValues.size() > 0) {
			return Collections.max(profileInfoValues).getDate();
		}
		return null;
	}

	public Double getCurrentValue() {
		ProfileInfoValueEntity pive = getCurrentInfoValue();
		if (pive != null) {
			return pive.getValue();
		}
		return null;
	}

	public ProfileInfoValueEntity getCurrentInfoValue() {
		if (profileInfoValues.size() > 0) {
			return Collections.max(profileInfoValues);
		}
		return null;
	}

	public Double getProgress() {
		if (profileInfoValues.size() > 0) {
			double max = Collections.max(profileInfoValues).getValue();
			double min = Collections.min(profileInfoValues).getValue();
			return max - min;
		}
		return null;
	}
}
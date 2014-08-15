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

import pl.jrola.java.www.vigym.model.entities.UnitEntity;
import pl.jrola.java.www.vigym.model.DbUtils;

@Entity
@Table(name=DbUtils.PROFILE_INFO_VALUES_TABLE.TABLE_NAME)
public class ProfileInfoValueEntity implements Serializable {

	private static final long serialVersionUID = 1974609759046360098L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=DbUtils.PROFILE_INFO_VALUES_TABLE.ID)
	private Long id;
	
	@Column(name=DbUtils.PROFILE_INFO_VALUES_TABLE.DATE)
	private Date date;
	
	@Column(name=DbUtils.PROFILE_INFO_VALUES_TABLE.VALUE)
	private Double value;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name=DbUtils.PROFILE_INFO_VALUES_TABLE.UNIT)
	private UnitEntity unit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name=DbUtils.PROFILE_INFO_VALUES_TABLE.PROF_INFO)
	private ProfileInfoEntity profileInfo;
	
	@Column(name=DbUtils.PROFILE_INFO_VALUES_TABLE.MOBILE_ID)
	private Long mobileId;
	
	public ProfileInfoValueEntity() {

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

	public UnitEntity getUnit() {
		return unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

	public ProfileInfoEntity getProfileInfo() {
		return profileInfo;
	}

	public void setProfileInfo(ProfileInfoEntity profileInfo) {
		this.profileInfo = profileInfo;
	}

	public Long getMobileId() {
		return mobileId;
	}

	public void setMobileId(Long mobileId) {
		this.mobileId = mobileId;
	}
	
}
package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;

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
@Table(name=DbUtils.PROFILE_INFO_TABLE.TABLE_NAME)
public class ProfileInfoEntity implements Serializable {

	private static final long serialVersionUID = -5786134876596833297L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=DbUtils.PROFILE_INFO_TABLE.ID)
	private Long id;
	
	@Column(name=DbUtils.PROFILE_INFO_TABLE.NAME)
	private String name;
	
	@Column(name=DbUtils.PROFILE_INFO_TABLE.DESC)
	private String desc;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name=DbUtils.PROFILE_INFO_TABLE.USER)
	private UserEntity user;
	
	@Column(name=DbUtils.PROFILE_INFO_TABLE.MOBILE_ID)
	private Long mobileId;
	
	public ProfileInfoEntity() {

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
	
}
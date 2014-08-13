package pl.jrola.java.www.vigym.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="USERS")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -4274899788009303050L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long id;
	
	@Column(name="USER_NICKNAME")
	private String nickname;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@Column(name="USER_MAIL")
	private String email;
	
	@Column(name="USER_MOBILE_ID")
	private Long mobileId;

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
}
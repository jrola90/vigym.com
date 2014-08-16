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
@Table(name = DbUtils.UNITS_TABLE.TABLE_NAME)
public class UnitEntity implements Serializable {

	private static final long serialVersionUID = -6650400250996813120L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = DbUtils.UNITS_TABLE.ID)
	private Long id;

	@Column(name = DbUtils.UNITS_TABLE.NAME)
	private String name;

	@Column(name = DbUtils.UNITS_TABLE.DESC)
	private String desc;

	@Column(name = DbUtils.UNITS_TABLE.SHORT_NAME)
	private String shortName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "unit")
	private Set<ProfileInfoValueEntity> profileInfoValues = new HashSet<ProfileInfoValueEntity>();

	public UnitEntity() {
	}

	public UnitEntity(Long id, String name, String desc, String shortName) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.shortName = shortName;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Set<ProfileInfoValueEntity> getProfileInfoValues() {
		return profileInfoValues;
	}

	public void setProfileInfoValues(
			Set<ProfileInfoValueEntity> profileInfoValues) {
		this.profileInfoValues = profileInfoValues;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitEntity && ((UnitEntity) obj).id.equals(id)
				&& ((UnitEntity) obj).name.equals(name)
				&& ((UnitEntity) obj).desc.equals(desc)
				&& ((UnitEntity) obj).shortName.equals(shortName))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return id.intValue();
	}

}
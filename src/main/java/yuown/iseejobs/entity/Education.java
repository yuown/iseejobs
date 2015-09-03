package yuown.iseejobs.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "education", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
@AttributeOverrides(value = { @AttributeOverride(name = "id", column = @Column(name = "ID", insertable = false, updatable = false)),
		@AttributeOverride(name = "degree", column = @Column(name = "degree")),
		@AttributeOverride(name = "startmonth", column = @Column(name = "startmonth")),
		@AttributeOverride(name = "startyear", column = @Column(name = "startyear")),
		@AttributeOverride(name = "endmonth", column = @Column(name = "endmonth")),
		@AttributeOverride(name = "endyear", column = @Column(name = "endyear")),
		@AttributeOverride(name = "inprogress", column = @Column(name = "inprogress")),
		@AttributeOverride(name = "specialization", column = @Column(name = "specialization")),
		@AttributeOverride(name = "profileId", column = @Column(name = "profile_id"))
})
public class Education extends BaseEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 4289151143888117381L;

	private String degree;

	private int startMonth;

	private int startYear;

	private int endMonth;

	private int endYear;

	private boolean inProgress;

	private String specialization;

	private Integer profileId;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return (new HashCodeBuilder()).append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Education rhs = (Education) obj;
		return (new EqualsBuilder()).append(this.id, rhs.id).isEquals();
	}

	public String getDegree() {
		return degree;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}

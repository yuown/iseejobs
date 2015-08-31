package yuown.iseejobs.model;

import java.util.Set;

public class ProfileModel extends Model {

	/**
     * 
     */
	private static final long serialVersionUID = -3340859196299627969L;

	private String firstname;

	private String lastname;

	private String email;

	private String mobile;

	private String address;

	private Set<SkillModel> skills;
	
	private Set<EducationModel> educations;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress() {
		return address;
	}

	public Set<SkillModel> getSkills() {
		return skills;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSkills(Set<SkillModel> skills) {
		this.skills = skills;
	}

	public Set<EducationModel> getEducations() {
		return educations;
	}

	public void setEducations(Set<EducationModel> educations) {
		this.educations = educations;
	}
}

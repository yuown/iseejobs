package yuown.iseejobs.model;

public class SkillModel extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3340859196299627969L;

	private String title;

	private String comments;

	private Integer profileId;

	public String getTitle() {
		return title;
	}

	public String getComments() {
		return comments;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
}

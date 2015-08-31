package yuown.iseejobs.model;

public class EducationModel extends Model {

	/**
     * 
     */
	private static final long serialVersionUID = -3340859196299627969L;

	private String title;

	private int startMonth;

	private int startYear;

	private int endMonth;

	private int endYear;

	private boolean inProgress;

	private String comments;

	private ProfileModel profile;

	public String getTitle() {
		return title;
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

	public String getComments() {
		return comments;
	}

	public ProfileModel getProfile() {
		return profile;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}
}

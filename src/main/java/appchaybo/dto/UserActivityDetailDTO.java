package appchaybo.dto;

public class UserActivityDetailDTO extends AbstractDTO<UserActivityDetailDTO> {
	private RunDTO run;
	private ActivityDTO activity;
	private String comment;
	private Integer mood;
	
	public RunDTO getRun() {
		return run;
	}
	public void setRun(RunDTO run) {
		this.run = run;
	}
	public ActivityDTO getActivity() {
		return activity;
	}
	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getMood() {
		return mood;
	}
	public void setMood(Integer mood) {
		this.mood = mood;
	}
}

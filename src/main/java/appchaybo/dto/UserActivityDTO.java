package appchaybo.dto;

public class UserActivityDTO extends AbstractDTO<UserActivityDTO>{
	
	private RunDTO run;
	private Long activityId;
	private String comment;
	private Integer mood;
	
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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
	public RunDTO getRun() {
		return run;
	}
	public void setRun(RunDTO run) {
		this.run = run;
	}

}

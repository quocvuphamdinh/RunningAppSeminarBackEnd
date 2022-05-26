package appchaybo.dto;

public class ActivityWorkoutDTO extends AbstractDTO<ActivityWorkoutDTO> {

	private Long activityId;
	private Long workoutId;
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}
	
}

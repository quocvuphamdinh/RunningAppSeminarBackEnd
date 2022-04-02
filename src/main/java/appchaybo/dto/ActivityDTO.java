package appchaybo.dto;

import java.util.ArrayList;
import java.util.List;

public class ActivityDTO extends AbstractDTO<ActivityDTO>{
	private String name;
	private Integer type;
	private Integer durationOfWorkouts;
	private List<WorkoutDTO> workouts = new  ArrayList<WorkoutDTO>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDurationOfWorkouts() {
		return durationOfWorkouts;
	}
	public void setDurationOfWorkouts(Integer durationOfWorkouts) {
		this.durationOfWorkouts = durationOfWorkouts;
	}
	public List<WorkoutDTO> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(List<WorkoutDTO> workouts) {
		this.workouts = workouts;
	}
	
	
}

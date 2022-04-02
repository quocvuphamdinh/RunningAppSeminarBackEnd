package appchaybo.dto;

public class WorkoutDTO extends AbstractDTO<WorkoutDTO>{
	private String name;
	private Long duration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}

}

package appchaybo.dto;

public class RunDTO extends AbstractDTO<RunDTO>{
	
	private Long timestamp;
	private Float averageSpeedInKilometersPerHour;
	private Integer distanceInKilometers;
	private Long timeInMillis;
	private Integer caloriesBurned;
	private Long userId;
	private Long activitiesId;
	
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Float getAverageSpeedInKilometersPerHour() {
		return averageSpeedInKilometersPerHour;
	}
	public void setAverageSpeedInKilometersPerHour(Float averageSpeedInKilometersPerHour) {
		this.averageSpeedInKilometersPerHour = averageSpeedInKilometersPerHour;
	}
	public Integer getDistanceInKilometers() {
		return distanceInKilometers;
	}
	public void setDistanceInKilometers(Integer distanceInKilometers) {
		this.distanceInKilometers = distanceInKilometers;
	}
	public Long getTimeInMillis() {
		return timeInMillis;
	}
	public void setTimeInMillis(Long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}
	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getActivitiesId() {
		return activitiesId;
	}
	public void setActivitiesId(Long activitiesId) {
		this.activitiesId = activitiesId;
	}
	
	
}

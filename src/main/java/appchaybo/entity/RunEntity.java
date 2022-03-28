package appchaybo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "run")
public class RunEntity {
	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date runTime;
	
	@Column(name="average_speed")
	private Double avgSpeedInKMH;
	
	@Column
	private Integer distanceInKilometers;
	
	@Column
	private Date timeInMillis;
	
	@Column
	private Integer caloriesBurned;
	
	@Column
	private Long runId;

	
	public Long getRunId() {
		return runId;
	}

	public void setRunId(Long runId) {
		this.runId = runId;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "userRunning")
	private List<UserActivityEntity>userActivityEntities = new ArrayList<UserActivityEntity>();
	
	
	public List<UserActivityEntity> getUserActivityEntities() {
		return userActivityEntities;
	}

	public void setUserActivityEntities(List<UserActivityEntity> userActivityEntities) {
		this.userActivityEntities = userActivityEntities;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Date getRunTime() {
		return runTime;
	}

	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}

	public Double getAvgSpeedInKMH() {
		return avgSpeedInKMH;
	}

	public void setAvgSpeedInKMH(Double avgSpeedInKMH) {
		this.avgSpeedInKMH = avgSpeedInKMH;
	}

	public Integer getDistanceInKilometers() {
		return distanceInKilometers;
	}

	public void setDistanceInKilometers(Integer distanceInKilometers) {
		this.distanceInKilometers = distanceInKilometers;
	}

	public Date getTimeInMillis() {
		return timeInMillis;
	}

	public void setTimeInMillis(Date timeInMillis) {
		this.timeInMillis = timeInMillis;
	}

	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public Long getId() {
		return id;
	}
	
	
}

package appchaybo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class ActivityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer type;
	
	@Column
	private Integer isUseGps;
	
	@Column
	private Integer durationOfWorkouts;
	
//	@ManyToMany
//	@JoinTable(name = "activity_workout", joinColumns = @JoinColumn(name ="activity_id"), inverseJoinColumns = @JoinColumn(name = "workout_id"))
//	private List<WorkoutEntity>workoutEntities = new ArrayList<WorkoutEntity>();
	
	@OneToMany(mappedBy = "activity")
	private List<ActivityWorkoutEntity>activityWorkoutEntities = new ArrayList<ActivityWorkoutEntity>();

	public List<ActivityWorkoutEntity> getActivityWorkoutEntities() {
		return activityWorkoutEntities;
	}

	public void setActivityWorkoutEntities(List<ActivityWorkoutEntity> activityWorkoutEntities) {
		this.activityWorkoutEntities = activityWorkoutEntities;
	}

	@OneToMany(mappedBy = "activity")
	private List<UserActivityEntity>userActivityEntities = new ArrayList<UserActivityEntity>();
	
	
	public List<UserActivityEntity> getUserActivityEntities() {
		return userActivityEntities;
	}

	public void setUserActivityEntities(List<UserActivityEntity> userActivityEntities) {
		this.userActivityEntities = userActivityEntities;
	}

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

	public Integer getIsUseGps() {
		return isUseGps;
	}

	public void setIsUseGps(Integer isUseGps) {
		this.isUseGps = isUseGps;
	}

	public Integer getDurationOfWorkouts() {
		return durationOfWorkouts;
	}

	public void setDurationOfWorkouts(Integer durationOfWorkouts) {
		this.durationOfWorkouts = durationOfWorkouts;
	}

	public Long getId() {
		return id;
	}
	
	
}

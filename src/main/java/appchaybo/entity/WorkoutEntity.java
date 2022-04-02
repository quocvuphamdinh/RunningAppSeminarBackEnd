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
@Table(name = "workout")
public class WorkoutEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Long duration;
	
//	@ManyToMany(mappedBy = "workoutEntities")
//	private List<ActivityEntity>activityEntities = new ArrayList<ActivityEntity>();
	
	@OneToMany(mappedBy = "workout")
	private List<ActivityWorkoutEntity>activityWorkoutEntities = new ArrayList<ActivityWorkoutEntity>();

	public List<ActivityWorkoutEntity> getActivityWorkoutEntities() {
		return activityWorkoutEntities;
	}

	public void setActivityWorkoutEntities(List<ActivityWorkoutEntity> activityWorkoutEntities) {
		this.activityWorkoutEntities = activityWorkoutEntities;
	}

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

//	public List<ActivityEntity> getActivityEntities() {
//		return activityEntities;
//	}
//
//	public void setActivityEntities(List<ActivityEntity> activityEntities) {
//		this.activityEntities = activityEntities;
//	}

	public Long getId() {
		return id;
	}
	
	
}

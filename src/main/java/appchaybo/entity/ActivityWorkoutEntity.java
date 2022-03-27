package appchaybo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activity_workout")
public class ActivityWorkoutEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workout;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private ActivityEntity activity;

	public WorkoutEntity getWorkout() {
		return workout;
	}

	public void setWorkout(WorkoutEntity workout) {
		this.workout = workout;
	}

	public ActivityEntity getActivity() {
		return activity;
	}

	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}
    
    
}

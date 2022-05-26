package appchaybo.converter;

import org.springframework.stereotype.Component;

import appchaybo.dto.ActivityWorkoutDTO;
import appchaybo.entity.ActivityWorkoutEntity;

@Component
public class ActivityWorkoutConverter {

	public ActivityWorkoutDTO toDTO(ActivityWorkoutEntity activityWorkoutEntity) {
		ActivityWorkoutDTO activityWorkoutDTO = new ActivityWorkoutDTO();
		activityWorkoutDTO.setId(activityWorkoutEntity.getId());
		activityWorkoutDTO.setActivityId(activityWorkoutEntity.getActivity().getId());
		activityWorkoutDTO.setWorkoutId(activityWorkoutEntity.getWorkout().getId());
		return activityWorkoutDTO;
	}
}

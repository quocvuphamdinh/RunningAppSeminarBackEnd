package appchaybo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import appchaybo.dto.ActivityDTO;
import appchaybo.dto.WorkoutDTO;
import appchaybo.entity.ActivityEntity;

@Component
public class ActivityConverter {
	
	public ActivityDTO toDTO(ActivityEntity entity) {
		ActivityDTO dto = new ActivityDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setType(entity.getType());
		dto.setDurationOfWorkouts(entity.getDurationOfWorkouts());
		List<WorkoutDTO> workouts = new ArrayList<WorkoutDTO>();
		for(int i=0 ;i <entity.getActivityWorkoutEntities().size();i++) {
			WorkoutDTO workoutDTO = new WorkoutDTO();
			workoutDTO.setId(entity.getActivityWorkoutEntities().get(i).getWorkout().getId());
			workoutDTO.setName(entity.getActivityWorkoutEntities().get(i).getWorkout().getName());
			workoutDTO.setDuration(entity.getActivityWorkoutEntities().get(i).getWorkout().getDuration());
			workouts.add(workoutDTO);
		}
		dto.setWorkouts(workouts);
		return dto;
	}
}

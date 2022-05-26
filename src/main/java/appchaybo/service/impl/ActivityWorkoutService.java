package appchaybo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.ActivityWorkoutConverter;
import appchaybo.dto.ActivityWorkoutDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.ActivityWorkoutEntity;
import appchaybo.entity.WorkoutEntity;
import appchaybo.repository.ActivityRepository;
import appchaybo.repository.ActivityWorkoutRepository;
import appchaybo.repository.WorkoutRepository;
import appchaybo.service.IActivityWorkoutService;

@Service
public class ActivityWorkoutService implements IActivityWorkoutService {

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private ActivityWorkoutRepository activityWorkoutRepository;
	
	@Autowired
	private ActivityWorkoutConverter activityWorkoutConverter;
	
	@Override
	public ActivityWorkoutDTO insertActivityWorkout(ActivityWorkoutDTO activityWorkoutDTO) {
		ActivityEntity activityEntity = activityRepository.findOne(activityWorkoutDTO.getActivityId());
		WorkoutEntity workoutEntity = workoutRepository.findOne(activityWorkoutDTO.getWorkoutId());
		ActivityWorkoutEntity activityWorkoutEntity = new ActivityWorkoutEntity();
		activityWorkoutEntity.setActivity(activityEntity);
		activityWorkoutEntity.setWorkout(workoutEntity);
		activityWorkoutEntity = activityWorkoutRepository.save(activityWorkoutEntity);
		return activityWorkoutConverter.toDTO(activityWorkoutEntity);
	}
}

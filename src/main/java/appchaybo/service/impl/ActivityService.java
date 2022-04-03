package appchaybo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.ActivityConverter;
import appchaybo.dto.ActivityDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.ActivityWorkoutEntity;
import appchaybo.entity.WorkoutEntity;
import appchaybo.repository.ActivityRepository;
import appchaybo.repository.ActivityWorkoutRepository;
import appchaybo.repository.WorkoutRepository;
import appchaybo.service.IActivityService;

@Service
public class ActivityService implements IActivityService{
	
	@Autowired
	private ActivityConverter activityConverter;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private ActivityWorkoutRepository activityWorkoutRepository;
	
	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public List<ActivityDTO> findByType(Integer type) {
		List<ActivityEntity> activityEntities = activityRepository.findByType(type);
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		for(int i =0 ; i< activityEntities.size(); i++) {
			List<ActivityWorkoutEntity> activityWorkoutEntities = activityWorkoutRepository.findByActivityId(activityEntities.get(i).getId());
			for(int j =0 ;j < activityWorkoutEntities.size() ; j++) {
				WorkoutEntity workoutEntity = workoutRepository.findOne(activityWorkoutEntities.get(j).getWorkout().getId());
				activityWorkoutEntities.get(j).setWorkout(workoutEntity);
			}
			activityDTOs.add(activityConverter.toDTO(activityEntities.get(i)));
		}
		return activityDTOs;
	}

	@Override
	public ActivityDTO findById(Long id) {
		ActivityEntity activityEntity = activityRepository.findOne(id);
		ActivityDTO activityDTO = new ActivityDTO();
		List<ActivityWorkoutEntity> activityWorkoutEntities = activityWorkoutRepository.findByActivityId(activityEntity.getId());
		for(int j =0 ;j < activityWorkoutEntities.size() ; j++) {
			WorkoutEntity workoutEntity = workoutRepository.findOne(activityWorkoutEntities.get(j).getWorkout().getId());
			activityWorkoutEntities.get(j).setWorkout(workoutEntity);
		}
		activityDTO = activityConverter.toDTO(activityEntity);
		return activityDTO;
	}
}

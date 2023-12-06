package appchaybo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.ActivityConverter;
import appchaybo.dto.ActivityDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.ActivityWorkoutEntity;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;
import appchaybo.entity.WorkoutEntity;
import appchaybo.repository.ActivitiesUserRepository;
import appchaybo.repository.ActivityRepository;
import appchaybo.repository.ActivityWorkoutRepository;
import appchaybo.repository.RunRepository;
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
	
	@Autowired
	private ActivitiesUserRepository activitiesUserRepository;
	
	@Autowired
	private RunRepository runRepository;
	
	@Override
	public List<ActivityDTO> findByType(Integer type, Long userId, Long size) {
		List<ActivityEntity> activityEntities = activityRepository.findByType(type);
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		for(int i =0 ; i< activityEntities.size(); i++) {
			List<ActivityWorkoutEntity> activityWorkoutEntities = activityWorkoutRepository.findByActivityId(activityEntities.get(i).getId());
			int durationInMinute = 0;
			for(int j =0 ;j < activityWorkoutEntities.size() ; j++) {
				WorkoutEntity workoutEntity = workoutRepository.findOne(activityWorkoutEntities.get(j).getWorkout().getId());
				durationInMinute += (workoutEntity.getDuration() / 60000F);
				activityWorkoutEntities.get(j).setWorkout(workoutEntity);
			}
			List<RunEntity> runEntity = runRepository.findByUserId(userId);
			List<UserActivityEntity> userActivityEntity = new ArrayList<UserActivityEntity>();
			for(int u =0;u<runEntity.size();u++) {
				UserActivityEntity userActivityEntity2 = activitiesUserRepository.findOneByUserRunning(runEntity.get(u));
				if(userActivityEntity2!=null) {
					userActivityEntity.add(userActivityEntity2);
				}
			}
			Boolean check = false;
			ActivityDTO activityDTO = activityConverter.toDTO(activityEntities.get(i));
			for(int l=0;l<userActivityEntity.size();l++) {
				RunEntity runEntity2 = userActivityEntity.get(l).getUserRunning();
				Long duration = 0L;
				for(int k =0 ; k<activityEntities.get(i).getActivityWorkoutEntities().size();k++) {
					duration+=activityEntities.get(i).getActivityWorkoutEntities().get(k).getWorkout().getDuration();
				}
				if(runEntity2.getTimeInMillis().getTime() >= duration) {
					activityDTO.setIsCompleted(1);
					check = true;
					break;
				}
			}
			if(!check) {
				activityDTO.setIsCompleted(0);
			}
			activityDTO.setDurationOfWorkouts(durationInMinute);
			activityDTOs.add(activityDTO);
			
			if(activityDTOs.size() == size && size != 0L) {
				break;
			}
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

	@Override
	public ActivityDTO insertActivity(ActivityDTO activityDTO) {
		ActivityEntity activityEntity = activityConverter.toEntity(activityDTO);
		activityEntity = activityRepository.save(activityEntity);
		return activityConverter.toDTO(activityEntity);
	}

	@Override
	public List<ActivityDTO> findAllActivities() {
		List<ActivityEntity> activityEntities = activityRepository.findAll();
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		for(int i = 0; i<activityEntities.size();i++) {
			ActivityDTO activityDTO = activityConverter.toDTO(activityEntities.get(i));
			activityDTOs.add(activityDTO);
		}
		return activityDTOs;
	}
}

package appchaybo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.RunConverter;
import appchaybo.converter.UserActivityConverter;
import appchaybo.dto.UserActivityDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;
import appchaybo.repository.ActivitiesUserRepository;
import appchaybo.repository.ActivityRepository;
import appchaybo.service.IUserActivityService;

@Service
public class UserActivityService implements IUserActivityService {
	
	@Autowired
	private ActivitiesUserRepository activitiesUserRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private RunConverter runConverter;
	
	@Autowired
	private UserActivityConverter userActivityConverter;

	@Override
	public UserActivityDTO insertUserActivity(UserActivityDTO activityDTO) {
		UserActivityEntity userActivityEntity = new UserActivityEntity();
		RunEntity runEntity = runConverter.toEntity(activityDTO.getRun());
		ActivityEntity activityEntity = activityRepository.findOne(activityDTO.getActivityId());
		userActivityEntity =  userActivityConverter.toEntity(activityDTO);
		userActivityEntity.setUserRunning(runEntity);
		userActivityEntity.setActivity(activityEntity);
		userActivityEntity = activitiesUserRepository.save(userActivityEntity);
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		if(userActivityEntity!=null) {
			userActivityDTO = userActivityConverter.toDTO(userActivityEntity);
			userActivityDTO.setRun(runConverter.toDTO(userActivityEntity.getUserRunning()));
			return userActivityDTO;
		}
		return null;
	}
}

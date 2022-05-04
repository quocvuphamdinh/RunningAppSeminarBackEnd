package appchaybo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.ActivityConverter;
import appchaybo.converter.RunConverter;
import appchaybo.converter.UserActivityConverter;
import appchaybo.dto.ActivityDTO;
import appchaybo.dto.RunDTO;
import appchaybo.dto.UserActivityDTO;
import appchaybo.dto.UserActivityDetailDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;
import appchaybo.entity.UserEntity;
import appchaybo.repository.ActivitiesUserRepository;
import appchaybo.repository.ActivityRepository;
import appchaybo.repository.RunRepository;
import appchaybo.repository.UserRepository;
import appchaybo.service.IUserActivityService;

@Service
public class UserActivityService implements IUserActivityService {
	
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private RunConverter runConverter;
	
	@Autowired
	private ActivityConverter activityConverter;
	
	@Autowired
	private UserActivityConverter userActivityConverter;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RunRepository runRepository2;
	
	@Autowired
	private ActivitiesUserRepository activitiesUserRepository2;
	
	
	@Override
	public UserActivityDTO insertUserActivity(UserActivityDTO activityDTO) {
		UserActivityEntity userActivityEntity = new UserActivityEntity();
		RunEntity runEntity = runConverter.toEntity(activityDTO.getRun());
		ActivityEntity activityEntity = activityRepository.findOne(activityDTO.getActivityId());
		userActivityEntity =  userActivityConverter.toEntity(activityDTO);
		UserEntity userEntity = userRepository.findOne(activityDTO.getRun().getUserId());
		runEntity.setUser(userEntity);
		userActivityEntity.setUserRunning(runEntity);
		userActivityEntity.setActivity(activityEntity);
		userActivityEntity = activitiesUserRepository2.save(userActivityEntity);
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		if(userActivityEntity!=null) {
			userActivityDTO = userActivityConverter.toDTO(userActivityEntity);
			userActivityDTO.setRun(runConverter.toDTO(runEntity));
			return userActivityDTO;
		}
		return null;
	}

	@Override
	public List<UserActivityDetailDTO> getListUserActivity(Long userId) {
		List<RunEntity> runEntities = runRepository2.findByUserIdOrderByIdDesc(userId);
		List<UserActivityDetailDTO> userActivityDetailDTOs = new ArrayList<UserActivityDetailDTO>();
		for(int i = 0; i<runEntities.size();i++) {
			UserActivityEntity userActivityEntity = activitiesUserRepository2.findOneByUserRunning(runEntities.get(i));
			if(userActivityEntity!=null) {
				ActivityDTO activityDTO = activityConverter.toDTO(userActivityEntity.getActivity());
				RunDTO runDTO = runConverter.toDTO(userActivityEntity.getUserRunning());
				UserActivityDetailDTO userActivityDetailDTO = userActivityConverter.toDetailDTO(userActivityEntity);
				userActivityDetailDTO.setActivity(activityDTO);
				userActivityDetailDTO.setRun(runDTO);
				userActivityDetailDTOs.add(userActivityDetailDTO);
			}
		}
		return userActivityDetailDTOs;
	}

	@Override
	public HashMap<String, String> calculateDataRecentActivity(Long userId) {
		List<UserActivityDetailDTO> userActivityDetailDTOs = getListUserActivity(userId);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Integer distance = 0;
		Long duration = 0L;
		Integer caloriesBurned = 0;
		float avgSpeed = 0F;
		for(int i = 0; i< userActivityDetailDTOs.size();i++) {
			distance += userActivityDetailDTOs.get(i).getRun().getDistanceInKilometers();
			duration += userActivityDetailDTOs.get(i).getRun().getTimeInMillis();
			caloriesBurned += userActivityDetailDTOs.get(i).getRun().getCaloriesBurned();
			avgSpeed += userActivityDetailDTOs.get(i).getRun().getAverageSpeedInKilometersPerHour();
		}
		hashMap.put("distance", distance.toString());
		hashMap.put("duration", duration.toString());
		hashMap.put("caloriesBurned", caloriesBurned.toString());
		avgSpeed = (float) (Math.round(avgSpeed * 100.0) / 100.0);
		hashMap.put("avgSpeed", String.valueOf(avgSpeed));
		return hashMap;
	}
}

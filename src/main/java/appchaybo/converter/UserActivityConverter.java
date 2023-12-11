package appchaybo.converter;

import org.springframework.stereotype.Component;

import appchaybo.dto.UserActivityDTO;
import appchaybo.dto.UserActivityDetailDTO;
import appchaybo.entity.ActivityEntity;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;

@Component
public class UserActivityConverter {
	
	public UserActivityEntity toEntity(UserActivityDTO userActivityDTO) {
		UserActivityEntity userActivityEntity = new UserActivityEntity();
		if(userActivityDTO.getId()!=null) {
			userActivityEntity.setId(userActivityDTO.getId());
		}
		userActivityEntity.setComment(userActivityDTO.getComment());
		userActivityEntity.setMood(userActivityDTO.getMood());
		
		return userActivityEntity;
	}
	
	public UserActivityEntity toEntity(UserActivityDTO userActivityDTO, ActivityEntity activityEntity, RunEntity runEntity, UserActivityEntity userActivityEntity) {
		userActivityEntity.setActivity(activityEntity);
		userActivityEntity.setUserRunning(runEntity);
		userActivityEntity.setComment(userActivityDTO.getComment());
		userActivityEntity.setMood(userActivityDTO.getMood());
		return userActivityEntity;
	}
	
	public UserActivityDTO toDTO(UserActivityEntity userActivityEntity) {
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		userActivityDTO.setId(userActivityEntity.getId());
		userActivityDTO.setComment(userActivityEntity.getComment());
		userActivityDTO.setMood(userActivityEntity.getMood());
		userActivityDTO.setActivityId(userActivityEntity.getActivity().getId());
		return userActivityDTO;
	}
	
	public UserActivityDetailDTO toDetailDTO(UserActivityEntity userActivityEntity) {
		UserActivityDetailDTO userActivityDetailDTO = new UserActivityDetailDTO();
		userActivityDetailDTO.setId(userActivityEntity.getId());
		userActivityDetailDTO.setComment(userActivityEntity.getComment());
		userActivityDetailDTO.setMood(userActivityEntity.getMood());
		return userActivityDetailDTO;
	}
}

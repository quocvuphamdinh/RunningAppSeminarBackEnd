package appchaybo.converter;

import org.springframework.stereotype.Component;

import appchaybo.dto.UserActivityDTO;
import appchaybo.entity.UserActivityEntity;

@Component
public class UserActivityConverter {
	
	public UserActivityEntity toEntity(UserActivityDTO userActivityDTO) {
		UserActivityEntity userActivityEntity = new UserActivityEntity();
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
}

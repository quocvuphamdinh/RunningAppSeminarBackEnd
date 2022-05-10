package appchaybo.service;

import java.util.HashMap;
import java.util.List;

import appchaybo.dto.UserActivityDTO;
import appchaybo.dto.UserActivityDetailDTO;

public interface IUserActivityService {
	UserActivityDTO insertUserActivity(UserActivityDTO activityDTO);
	UserActivityDTO updateUserActivity(UserActivityDTO userActivityDTO);
	List<UserActivityDetailDTO> getListUserActivity(Long userId);
	HashMap<String, String> calculateDataRecentActivity(Long userId);
	UserActivityDetailDTO getDetailUserActivity(Long userActivityId);
	HashMap<String, Boolean> deleteUserActivity(Long userActivityId);
}

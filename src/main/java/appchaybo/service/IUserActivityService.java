package appchaybo.service;

import java.util.List;

import appchaybo.dto.UserActivityDTO;
import appchaybo.dto.UserActivityDetailDTO;

public interface IUserActivityService {
	UserActivityDTO insertUserActivity(UserActivityDTO activityDTO);
	List<UserActivityDetailDTO> getListUserActivity(Long userId);
}

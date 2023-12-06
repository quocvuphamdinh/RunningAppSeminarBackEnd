package appchaybo.service;

import java.util.List;

import appchaybo.dto.ActivityDTO;

public interface IActivityService {
	public List<ActivityDTO> findByType(Integer type, Long userId, Long size);
	public ActivityDTO findById(Long id);
	public ActivityDTO insertActivity(ActivityDTO activityDTO);
	public List<ActivityDTO> findAllActivities();
}

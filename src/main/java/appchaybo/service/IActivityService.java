package appchaybo.service;

import java.util.List;

import appchaybo.dto.ActivityDTO;

public interface IActivityService {
	public List<ActivityDTO> findByType(Integer type, Long userId);
	public ActivityDTO findById(Long id);
}

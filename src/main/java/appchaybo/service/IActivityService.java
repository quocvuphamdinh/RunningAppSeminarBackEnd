package appchaybo.service;

import java.util.List;

import appchaybo.dto.ActivityDTO;

public interface IActivityService {
	public List<ActivityDTO> findByType(Integer type);
	public ActivityDTO findById(Long id);
}

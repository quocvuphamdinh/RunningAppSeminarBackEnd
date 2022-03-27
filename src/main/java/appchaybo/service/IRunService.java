package appchaybo.service;

import java.util.List;

import appchaybo.dto.RunDTO;

public interface IRunService {
	
	RunDTO save(RunDTO runDTO);
	List<RunDTO> findByUserId(Long userId);
}

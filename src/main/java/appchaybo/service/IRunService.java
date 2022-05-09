package appchaybo.service;

import java.util.HashMap;
import java.util.List;

import appchaybo.dto.RunDTO;

public interface IRunService {
	
	RunDTO save(RunDTO runDTO);
	List<RunDTO> findByUserId(Long userId);
	HashMap<String, String> deleteRun(RunDTO run);
}

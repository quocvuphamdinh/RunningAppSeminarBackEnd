package appchaybo.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.RunDTO;
import appchaybo.service.IRunService;

@RestController
public class RunAPI {
	
	@Autowired
	private IRunService runService;

	@GetMapping(value = "/run/{userId}")
	public List<RunDTO> getRun(@PathVariable("userId") Long userId) {
		return runService.findByUserId(userId);
	}
	
	@PostMapping(value ="/run/{userId}/{userActivitesId}")
	public RunDTO insertRun(@RequestBody RunDTO runDTO, @PathVariable("userId") Long userId, @PathVariable("userActivitesId") Long userActivitesId) {
		runDTO.setUserId(userId);
		if(userActivitesId!=-1) {
			runDTO.setActivitiesId(userActivitesId);
		}
		return runService.save(runDTO);
	}
	
	@PutMapping(value ="/run/{id}")
	public RunDTO updateRun(@RequestBody RunDTO runDTO, @PathVariable("id") String id) {
		runDTO.setId(id);
		return runService.save(runDTO);
	}
	
	@DeleteMapping(value = "/run/delete")
	public HashMap<String, String> deleteRun(@RequestBody RunDTO run){
		return runService.deleteRun(run);
	}

}

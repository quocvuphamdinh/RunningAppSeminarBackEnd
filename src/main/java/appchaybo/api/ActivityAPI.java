package appchaybo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.ActivityDTO;
import appchaybo.service.IActivityService;

@RestController
public class ActivityAPI {

	@Autowired
	private IActivityService activityService;
	
	@GetMapping(value = "/activity/{type}/{userId}")
	public List<ActivityDTO> getListActivity(@PathVariable("type") Integer type, @PathVariable("userId") Long userId){
		return activityService.findByType(type, userId);
	}
	
	@GetMapping(value = "/activity/detail/{id}")
	public ActivityDTO getListActivity(@PathVariable("id") Long id){
		return activityService.findById(id);
	}
}

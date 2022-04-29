package appchaybo.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.UserActivityDTO;
import appchaybo.dto.UserActivityDetailDTO;
import appchaybo.service.IUserActivityService;

@RestController
public class UserActivityAPI {

	@Autowired
	private IUserActivityService userActivityService;
	
	@PostMapping(value = "/user-activity/{userId}")
	public UserActivityDTO insertUserActivity(@RequestBody UserActivityDTO userActivityDTO, @PathVariable("userId") Long userId) {
		userActivityDTO.getRun().setUserId(userId);
		return userActivityService.insertUserActivity(userActivityDTO);
	}
	
	@GetMapping(value = "/user-activity/{userId}")
	public List<UserActivityDetailDTO> getListUserActivity(@PathVariable("userId") Long userId){
		return userActivityService.getListUserActivity(userId);
	}
	
	@GetMapping(value = "/user-activity/calculate-recent-activity/{userId}")
	public HashMap<String, String> calculateDataRecentActivity(@PathVariable("userId") Long userId){
		return userActivityService.calculateDataRecentActivity(userId);
	}
}

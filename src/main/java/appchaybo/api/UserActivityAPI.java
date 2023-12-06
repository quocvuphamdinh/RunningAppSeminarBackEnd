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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping(value = "/user-activity/{userId}")
	public UserActivityDTO updateUserActivity(@RequestBody UserActivityDTO userActivityDTO, @PathVariable("userId") Long userId){
		userActivityDTO.getRun().setUserId(userId);
		return userActivityService.updateUserActivity(userActivityDTO);
	}
	
	@GetMapping(value = "/user-activity/{userId}")
	public List<UserActivityDetailDTO> getListUserActivity(@PathVariable("userId") Long userId, @RequestParam("page") Long page){
		return userActivityService.getListUserActivity(userId, page);
	}
	
	@GetMapping(value = "/user-activity/calculate-recent-activity/{userId}")
	public HashMap<String, String> calculateDataRecentActivity(@PathVariable("userId") Long userId){
		return userActivityService.calculateDataRecentActivity(userId);
	}
	
	@GetMapping(value = "/user-activity/detail/{userActivityId}")
	public UserActivityDetailDTO getDetailUserActivity(@PathVariable("userActivityId") Long userActivityId) {
		return userActivityService.getDetailUserActivity(userActivityId);
	}
	
	@DeleteMapping(value = "/user-activity/{userActivityId}")
	public HashMap<String, Boolean> deleteUserActivity(@PathVariable("userActivityId") Long userActivityId){
		return userActivityService.deleteUserActivity(userActivityId);
	}
}

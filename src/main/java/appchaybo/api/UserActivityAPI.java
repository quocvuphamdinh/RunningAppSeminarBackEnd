package appchaybo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.UserActivityDTO;
import appchaybo.service.IUserActivityService;

@RestController
public class UserActivityAPI {

	@Autowired
	private IUserActivityService userActivityService;
	
	@PostMapping(value = "/user-activity")
	public UserActivityDTO insertUserActivity(@RequestBody UserActivityDTO userActivityDTO) {
		return userActivityService.insertUserActivity(userActivityDTO);
	}
}

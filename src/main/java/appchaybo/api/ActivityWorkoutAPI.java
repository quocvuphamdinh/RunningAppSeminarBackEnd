package appchaybo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.ActivityWorkoutDTO;
import appchaybo.service.IActivityWorkoutService;

@RestController
public class ActivityWorkoutAPI {

	@Autowired
	private IActivityWorkoutService activityWorkoutService;
	
	@PostMapping(value = "/activity-workout")
	public ActivityWorkoutDTO insertActivityWorkout(@RequestBody ActivityWorkoutDTO activityWorkoutDTO) {
		return activityWorkoutService.insertActivityWorkout(activityWorkoutDTO);
	}
}

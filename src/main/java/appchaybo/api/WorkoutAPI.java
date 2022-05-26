package appchaybo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.WorkoutDTO;
import appchaybo.service.IWorkoutService;

@RestController
public class WorkoutAPI {

	@Autowired
	private IWorkoutService workoutService;
	
	@GetMapping(value = "/workout")
	public List<WorkoutDTO> findAll() {
		return workoutService.findAllWorkouts();
	}
	
	@PostMapping(value = "/workout")
	public WorkoutDTO insertWorkout(@RequestBody WorkoutDTO workoutDTO) {
		return workoutService.insertWorkout(workoutDTO);
	}
}

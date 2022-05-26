package appchaybo.service;

import java.util.List;

import appchaybo.dto.WorkoutDTO;

public interface IWorkoutService {

	public WorkoutDTO insertWorkout(WorkoutDTO workoutDTO);
	public List<WorkoutDTO> findAllWorkouts();
}

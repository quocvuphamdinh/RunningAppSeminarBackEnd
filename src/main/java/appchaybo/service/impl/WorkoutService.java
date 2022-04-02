package appchaybo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.WorkoutConverter;
import appchaybo.repository.WorkoutRepository;
import appchaybo.service.IWorkoutService;

@Service
public class WorkoutService implements IWorkoutService{

	@Autowired
	private WorkoutConverter workoutConverter;
	
	@Autowired
	private WorkoutRepository workoutRepository;
}

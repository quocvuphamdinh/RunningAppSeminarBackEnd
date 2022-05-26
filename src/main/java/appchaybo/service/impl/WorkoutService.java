package appchaybo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.WorkoutConverter;
import appchaybo.dto.WorkoutDTO;
import appchaybo.entity.WorkoutEntity;
import appchaybo.repository.WorkoutRepository;
import appchaybo.service.IWorkoutService;

@Service
public class WorkoutService implements IWorkoutService{

	@Autowired
	private WorkoutConverter workoutConverter;
	
	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public WorkoutDTO insertWorkout(WorkoutDTO workoutDTO) {
		WorkoutEntity workoutEntity = workoutConverter.toEntity(workoutDTO);
		workoutEntity = workoutRepository.save(workoutEntity);
		return workoutConverter.toDTO(workoutEntity);
	}

	@Override
	public List<WorkoutDTO> findAllWorkouts() {
		List<WorkoutEntity>workoutEntities = workoutRepository.findAll();
		List<WorkoutDTO>workoutDTOs = new ArrayList<WorkoutDTO>();
		for(int i=0; i<workoutEntities.size();i++) {
			workoutDTOs.add(workoutConverter.toDTO(workoutEntities.get(i)));
		}
		return workoutDTOs;
	}	
}

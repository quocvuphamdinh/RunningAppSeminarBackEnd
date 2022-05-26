package appchaybo.converter;

import org.springframework.stereotype.Component;

import appchaybo.dto.WorkoutDTO;
import appchaybo.entity.WorkoutEntity;

@Component
public class WorkoutConverter {

	public WorkoutDTO toDTO(WorkoutEntity entity) {
		WorkoutDTO dto = new WorkoutDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDuration(entity.getDuration());
		return dto;
	}
	public WorkoutEntity toEntity(WorkoutDTO dto) {
		WorkoutEntity workoutEntity = new WorkoutEntity();
		workoutEntity.setName(dto.getName());
		workoutEntity.setDuration(dto.getDuration());
		return workoutEntity;
	}
}

package appchaybo.converter;


import java.util.Date;

import org.springframework.stereotype.Component;

import appchaybo.dto.RunDTO;
import appchaybo.entity.RunEntity;

@Component
public class RunConverter {
	
	public RunEntity toEntity(RunDTO runDTO) {
		RunEntity runEntity = new RunEntity();
		if(runDTO.getId()!=null) {
			runEntity.setId(runDTO.getId());
		}
		runEntity.setRunTime(new Date(runDTO.getTimestamp()));
		runEntity.setAvgSpeedInKMH(Double.valueOf(runDTO.getAverageSpeedInKilometersPerHour().toString()));
		runEntity.setDistanceInKilometers(runDTO.getDistanceInKilometers());
		runEntity.setTimeInMillis(new Date(runDTO.getTimeInMillis()));
		runEntity.setCaloriesBurned(runDTO.getCaloriesBurned());
		return runEntity;
	}
	
	public RunDTO toDTO(RunEntity runEntity) {
		RunDTO runDTO = new RunDTO();
		if(runEntity.getId()!=null) {
			runDTO.setId(runEntity.getId());
		}
		runDTO.setTimestamp(runEntity.getRunTime().getTime());
		runDTO.setAverageSpeedInKilometersPerHour(Float.valueOf(runEntity.getAvgSpeedInKMH().toString()));
		runDTO.setDistanceInKilometers(runEntity.getDistanceInKilometers());
		runDTO.setTimeInMillis(runEntity.getTimeInMillis().getTime());
		runDTO.setCaloriesBurned(runEntity.getCaloriesBurned());
		runDTO.setUserId(runEntity.getUser().getId());
		if(runEntity.getUserActivityEntities().size()>0) {
			runDTO.setActivitiesId(runEntity.getUserActivityEntities().get(0).getId());
		}
		return runDTO;
	}
	
	public RunEntity toEntity(RunDTO runDTO, RunEntity runEntity) {
		runEntity.setRunTime(new Date(runDTO.getTimestamp()));
		runEntity.setAvgSpeedInKMH(Double.valueOf(runDTO.getAverageSpeedInKilometersPerHour().toString()));
		runEntity.setDistanceInKilometers(runDTO.getDistanceInKilometers());
		runEntity.setTimeInMillis(new Date(runDTO.getTimeInMillis()));
		runEntity.setCaloriesBurned(runDTO.getCaloriesBurned());
		return runEntity;
	}
}

package appchaybo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.RunConverter;
import appchaybo.dto.RunDTO;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;
import appchaybo.entity.UserEntity;
import appchaybo.repository.ActivitiesUserRepository;
import appchaybo.repository.RunRepository;
import appchaybo.repository.UserRepository;
import appchaybo.service.IRunService;


@Service
public class RunService implements IRunService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RunRepository runRepository;
	
	@Autowired
	private RunConverter runConverter;
	
	@Autowired
	private ActivitiesUserRepository userActivitiesRepository;

	@Override
	public RunDTO save(RunDTO runDTO) {
		RunEntity runEntity = new RunEntity();
		if(runRepository.findOneById(runDTO.getId())!=null) {
			RunEntity oldRunEntity = runRepository.findOneById(runDTO.getId());
			runEntity = runConverter.toEntity(runDTO, oldRunEntity);
		}else {
			runEntity = runConverter.toEntity(runDTO);
		}
		UserEntity userEntity = userRepository.findOne(runDTO.getUserId());
		runEntity.setUser(userEntity);
		List<UserActivityEntity>userActivityEntities = new ArrayList<UserActivityEntity>();
		if(runDTO.getActivitiesId()!=null) {
			userActivityEntities.add(userActivitiesRepository.findOne(runDTO.getActivitiesId()));
		}
		runEntity.setUserActivityEntities(userActivityEntities);
		runEntity = runRepository.save(runEntity);
		return runConverter.toDTO(runEntity);
	}

	@Override
	public List<RunDTO> findByUserId(Long userId) {
		List<RunEntity> runEntity = runRepository.findByUserId(userId);
		List<RunDTO> listRunDTO = new ArrayList<RunDTO>();
		for(int i=0;i<runEntity.size();i++) {
			listRunDTO.add(runConverter.toDTO(runEntity.get(i)));
		}
		return listRunDTO;
	}
}

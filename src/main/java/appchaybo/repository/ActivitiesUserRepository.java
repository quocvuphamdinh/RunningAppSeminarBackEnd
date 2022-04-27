package appchaybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;

public interface ActivitiesUserRepository extends JpaRepository<UserActivityEntity, Long>{
	
	public UserActivityEntity findOneByUserRunning(RunEntity runEntity);
}

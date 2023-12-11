package appchaybo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.ActivityEntity;
import appchaybo.entity.RunEntity;
import appchaybo.entity.UserActivityEntity;

public interface ActivitiesUserRepository extends JpaRepository<UserActivityEntity, Long>{
	
	public UserActivityEntity findOneByUserRunning(RunEntity runEntity);
	public List<UserActivityEntity> findByActivity(ActivityEntity activityEntity);
	public UserActivityEntity findOneByActivityAndUserRunning(ActivityEntity activityEntity, RunEntity runEntity);
}

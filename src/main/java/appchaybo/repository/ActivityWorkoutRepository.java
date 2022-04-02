package appchaybo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.ActivityWorkoutEntity;

public interface ActivityWorkoutRepository extends JpaRepository<ActivityWorkoutEntity, Long>{

	public List<ActivityWorkoutEntity> findByActivityId(Long activityId);
}

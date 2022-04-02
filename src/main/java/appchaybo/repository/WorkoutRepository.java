package appchaybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.WorkoutEntity;

public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long>{

}

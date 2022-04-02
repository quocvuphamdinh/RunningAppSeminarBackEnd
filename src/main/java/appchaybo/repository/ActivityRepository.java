package appchaybo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>{

	public List<ActivityEntity> findByType(Integer type);
}

package appchaybo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.RunEntity;

public interface RunRepository extends JpaRepository<RunEntity, Long>{
	
	List<RunEntity> findByUserId(Long userId);
	RunEntity findOneById(String id);
}

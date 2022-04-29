package appchaybo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.RunEntity;

public interface RunRepository extends JpaRepository<RunEntity, String>{
	
	List<RunEntity> findByUserId(Long userId);
	RunEntity findOneById(String id);
	List<RunEntity> findByUserIdOrderByIdDesc(Long userId);
}

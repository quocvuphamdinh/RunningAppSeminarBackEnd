package appchaybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.UserActivityEntity;

public interface ActivitiesUserRepository extends JpaRepository<UserActivityEntity, Long>{

}

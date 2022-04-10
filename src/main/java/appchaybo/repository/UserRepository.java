package appchaybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appchaybo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findOneByUsernameAndPassword(String userName, String passWord);
	UserEntity findOneByUsername(String userName);
}

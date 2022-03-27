package appchaybo.converter;

import org.springframework.stereotype.Component;

import appchaybo.dto.UserDTO;
import appchaybo.entity.UserEntity;

@Component // cho service hiểu class này là converter
public class UserConverter {
	
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassWord());
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setAvartar(userDTO.getAvartar());
		userEntity.setGender(userDTO.getGender());
		userEntity.setHeight(userDTO.getHeight());
		userEntity.setWeight(userDTO.getWeight());
		userEntity.setDistanceGoal(userDTO.getDistanceGoal());
		return userEntity;
	}
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		if(userEntity.getId()!=null) {
			userDTO.setId(userEntity.getId());
		}
		userDTO.setUserName(userEntity.getUsername());
		userDTO.setPassWord(userEntity.getPassword());
		userDTO.setFullName(userEntity.getFullName());
		userDTO.setAvartar(userEntity.getAvartar());
		userDTO.setGender(userEntity.getGender());
		userDTO.setHeight(userEntity.getHeight());
		userDTO.setWeight(userEntity.getWeight());
		userDTO.setDistanceGoal(userEntity.getDistanceGoal());
		return userDTO;
	}
	
	public UserEntity toEntity(UserDTO userDTO, UserEntity oldEntity) {
		oldEntity.setUsername(userDTO.getUserName());
		oldEntity.setPassword(userDTO.getPassWord());
		oldEntity.setFullName(userDTO.getFullName());
		oldEntity.setAvartar(userDTO.getAvartar());
		oldEntity.setGender(userDTO.getGender());
		oldEntity.setHeight(userDTO.getHeight());
		oldEntity.setWeight(userDTO.getWeight());
		oldEntity.setDistanceGoal(userDTO.getDistanceGoal());
		return oldEntity;
	}
}

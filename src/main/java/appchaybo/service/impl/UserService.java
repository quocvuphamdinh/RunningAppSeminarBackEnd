package appchaybo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appchaybo.converter.UserConverter;
import appchaybo.dto.UserDTO;
import appchaybo.entity.UserEntity;
import appchaybo.repository.UserRepository;
import appchaybo.service.IUserService;


@Service // để cho userapi hiểu để nhúng vào
public class UserService implements IUserService{
	
	@Autowired // nhúng repo vào service
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if(userDTO.getId()!=null) {
			UserEntity oldUser = userRepository.findOne(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO, oldUser);
		}else {
			userEntity = userConverter.toEntity(userDTO);
		}
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public UserDTO findOneByUsernameAndPassword(String userName, String passWord) {
		UserEntity userEntity = userRepository.findOneByUsernameAndPassword(userName, passWord);
		if(userEntity!=null) {
			return userConverter.toDTO(userEntity);
		}
		return new UserDTO("", "", "", "", "", 0, 0, 0L);
	}

//	@Override
//	public UserDTO update(UserDTO userDTO) {
//		UserEntity oldUser = userRepository.findOne(userDTO.getId());
//		UserEntity newUser = userConverter.toEntity(userDTO, oldUser);
//		newUser = userRepository.save(newUser);
//		return userConverter.toDTO(newUser);
//	}
}

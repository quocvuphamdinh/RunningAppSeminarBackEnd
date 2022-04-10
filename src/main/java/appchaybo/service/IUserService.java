package appchaybo.service;

import java.util.HashMap;

import appchaybo.dto.UserDTO;

public interface IUserService {
	
	UserDTO save(UserDTO userDTO);
	UserDTO findOneByUsernameAndPassword(String userName, String passWord);
	//UserDTO update(UserDTO userDTO);
	HashMap<String, String> resetPassword(String email);
	UserDTO checkEmailUser(String email);
}

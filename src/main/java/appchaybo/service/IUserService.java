package appchaybo.service;

import appchaybo.dto.UserDTO;

public interface IUserService {
	
	UserDTO save(UserDTO userDTO);
	UserDTO findOneByUsernameAndPassword(String userName, String passWord);
	//UserDTO update(UserDTO userDTO);
}

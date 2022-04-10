package appchaybo.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import appchaybo.dto.UserDTO;
import appchaybo.service.IUserService;

@RestController
public class UserAPI {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return userService.save(model);
	}
	
	@GetMapping(value ="/user/{userName}-{passWord}")
	public UserDTO getUser(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord) {
		return userService.findOneByUsernameAndPassword(userName, passWord);
	}
	
	@PutMapping(value ="/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") Long id) {
		model.setId(id);
		return userService.save(model);
	}
	
	@PutMapping(value = "/user/resetpassword")
	public HashMap<String, String> resetPassword(@RequestBody UserDTO user) {
		return userService.resetPassword(user.getUserName());
	}
	
	@GetMapping(value = "/user/checkemail/{userName}")
	public UserDTO checkEmailUser(@PathVariable("userName") String userName) {
		return userService.checkEmailUser(userName+".com");
	}
}

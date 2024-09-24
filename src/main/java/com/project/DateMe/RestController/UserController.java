package com.project.DateMe.RestController;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.DateMe.Models.User;
import com.project.DateMe.UserService_Impl.UserServices;
import com.project.DateMe.Utility.ModelObjectMapper;

import DTO.LoginDTO;
import DTO.UserDTO;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserServices userServices;
	private ModelObjectMapper util;
	
	
	public UserController(UserServices userServices, ModelObjectMapper util) {
		super();
		this.userServices = userServices;
		this.util = util;
	}

//this is api called for creating user or signing up for a new user, it returns a user created after saving it in database
	@PostMapping("/signin")
	public ResponseEntity<User> signinUser(@RequestBody UserDTO user) {
		User modeluser = util.changeToUser(user);
		userServices.createUserService(modeluser);
		return ResponseEntity.ok(modeluser);
		
		
	}
//this api is called for loggin in existing user with email and password
//returns message according to the result of action, successful,not found,wrong credential...
	@PostMapping("/userLogin")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO logindto){
		String result = userServices.loginUserService(logindto.getEmail(),logindto.getPassword());
		return ResponseEntity.ok(result);
		
		
	}
	
	@GetMapping("/userList")
	public ResponseEntity<List<User>> getUsers(@RequestParam("adminEmail") String adminEmail) {
		List<User> users = userServices.getUserService(adminEmail);
		return ResponseEntity.ok(users);
		
	}
	
	@PostMapping("/sendReq")
	public void sendReq() {}	;	

}

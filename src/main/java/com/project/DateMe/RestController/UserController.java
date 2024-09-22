package com.project.DateMe.RestController;
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


	@PostMapping("/signin")
	public ResponseEntity<User> signinUser(@RequestBody UserDTO user ,@PathParam("firstname") String name) {
		User modeluser = util.changeToUser(user);
		userServices.createUser(modeluser);
		return ResponseEntity.ok(modeluser);
		
		
	}
	@GetMapping("/getmsg")
	public ResponseEntity<String> getMsg(){
		String msg = "Hello World!!";
		return ResponseEntity.ok(msg);
		
	}
	@PostMapping("/userLogin")
	public ResponseEntity<String> loginUser(@RequestParam("email") String email, @RequestParam("password") String password){
		String result = userServices.loginUser(email,password);
		return ResponseEntity.ok(result);
		
		
	}
		

}

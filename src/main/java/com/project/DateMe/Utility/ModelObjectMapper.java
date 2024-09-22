package com.project.DateMe.Utility;

import org.springframework.stereotype.Service;

import com.project.DateMe.Models.User;

import DTO.UserDTO;
@Service
public class ModelObjectMapper {
	//this class will have extra utility function...
	
	public UserDTO changeToDTO(User user) {
		UserDTO userdto = new UserDTO(user.getFirstname(),user.getLastname(),user.getAge(),user.getAddress(),user.getPhone(),user.getEmail(),user.getPassword());
		return userdto;
		
	}
	public User changeToUser(UserDTO userdto) {
		User user = new User(userdto.getFirstname(),userdto.getLastname(),userdto.getAge(),userdto.getAddress(),userdto.getPhone(),userdto.getEmail(),userdto.getPassword());
		return user;
	}

}

package com.project.DateMe.UserService_Impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.DateMe.DAO.DAOCustom_I;
import com.project.DateMe.DAO.UserDAO;
import com.project.DateMe.Models.User;

import DTO.UserDTO;
import UserService_I.UserService_I;
@Service
public class UserServices implements UserService_I {

	private UserDAO userdao;
	private DAOCustom_I daocustom;
	public UserServices(UserDAO userdao,DAOCustom_I daocustom) {
		this.userdao = userdao;
		this.daocustom = daocustom;
	}
	@Override
	public User createUserService(User user) {
		User createdUser = userdao.save(user);
		return createdUser;
		
	}
	@Override
	public String loginUserService(String email, String password) {
		System.out.println("email:"+email +"pass:"+password);
	     //Check if email or password is null first
	    if (email == null || password == null) {
	        return "Email or password cannot be null";
	    }
	    //if user exists..
	    else {
	    
	    Optional<User> admin = userdao.findById(email);
	    if (admin.isPresent()) {
	        User user = admin.get(); //get user if it exists
	        String pass = user.getPassword(); //retrieving user's password
	        if (!password.equals(pass)) {
	            return "Password didn't match";  //if password donot match
	        }
	        return "Login successful"; // if it matches
	    }
	    return "No User found";
	}
	}
	
	@Override
	public List<User> getUserService(String adminEmail) {
		List<User> users = daocustom.getUsersExceptAdmin(adminEmail);
		return users;
	}
	


}
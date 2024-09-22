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

import com.project.DateMe.DAO.UserDAO;
import com.project.DateMe.Models.User;

import DTO.UserDTO;
import UserService_I.UserService_I;
@Service
public class UserServices implements UserService_I {

	private UserDAO userdao;
	public UserServices(UserDAO userdao) {
		this.userdao = userdao;
	}
	@Override
	public User createUser(User user) {
		User createdUser = userdao.save(user);
		return createdUser;
		
	}
	@Override
	public String loginUser(String email, String password) {
	     //Check if email or password is null first
	    if (email == null || password == null) {
	        return "Email or password cannot be null";
	    }
	    else {
	    
	    Optional<User> admin = userdao.findById(email);
	    if (admin.isPresent()) {
	        User user = admin.get();
	        String pass = user.getPassword();
	        if (!password.equals(pass)) {
	            return "Password didn't match";
	        }
	        return "Login successful"; // or any other success message
	    }
	    return "No User found";
	}
	}


}
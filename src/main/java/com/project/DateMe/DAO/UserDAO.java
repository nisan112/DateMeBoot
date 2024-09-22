package com.project.DateMe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.DateMe.Models.User;

import DTO.UserDTO;
@Repository
public interface UserDAO extends JpaRepository<User, String> {
	
	

}

package com.project.DateMe.DAO;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.project.DateMe.Models.User;


@Repository
public interface DAOCustom_I {
	
	public List<User> getUsersExceptAdmin(String adminEmail);
	
		
	}



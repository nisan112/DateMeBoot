package UserService_I;

import java.util.List;

import com.project.DateMe.DAO.UserDAO;
import com.project.DateMe.Models.User;

import DTO.UserDTO;

public interface UserService_I {
	User createUserService(User user);
	String loginUserService(String email,String password);
	List<User> getUserService(String adminEmail);
	

}

package com.project.DateMe.DAO;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.project.DateMe.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class DAOCustoms_Impl implements DAOCustom_I{
	@PersistenceContext
	private EntityManager entitymanager;


//returns all user for the homepage except the user(admin user) itself
	@Override
	public List<User> getUsersExceptAdmin(String adminEmail) {
		String hql = "From User Where email != :adminEmail";
		TypedQuery<User> q = entitymanager.createQuery(hql, User.class);
		q.setParameter("adminEmail", adminEmail);
		return q.getResultList();
		
		
	}

}

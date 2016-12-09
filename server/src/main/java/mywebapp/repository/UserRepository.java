package mywebapp.repository;

import java.util.List;

import mywebapp.entity.User;

public interface UserRepository {
	
	User save(User user);
	
	User findOne(String username);
	
	List<User> findAll();
	
	User findByUsername(String username);
}

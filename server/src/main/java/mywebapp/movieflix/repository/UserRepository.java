package mywebapp.movieflix.repository;

import java.util.List;

import mywebapp.movieflix.entities.User;

public interface UserRepository {
	
	User findUserByUsername(String username);

	 List<User> showAllUsers();
	
	 User showOneUser(String uid);
	
	 User createUser(User user);
	
	 User updateUser(User user);
	
	 void deleteUser(User user);
}

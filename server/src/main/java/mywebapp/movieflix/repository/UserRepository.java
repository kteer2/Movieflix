package mywebapp.movieflix.repository;

import java.util.List;

import mywebapp.movieflix.entities.User;

public interface UserRepository {

	public List<User> showAllUsers();
	
	public User showOneUser(String uid);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);
}

package mywebapp.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywebapp.movieflix.entities.User;
import mywebapp.movieflix.exception.ResourceNotFoundException;
import mywebapp.movieflix.exception.ResourceNotInSpecifiedLimit;
import mywebapp.movieflix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> showAllUsers() {
		return repository.showAllUsers();
	}

	@Override
	public User showOneUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		if(user.getEmail()==null || user.getPassword()==null)
		{
			throw new ResourceNotInSpecifiedLimit("Please fill all required fields");
		}
		return repository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String uid, User user) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return repository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		repository.deleteUser(existing);
	}
	@Override
	public User findUserByUsername(String username){
		return repository.findUserByUsername(username);
	}

}

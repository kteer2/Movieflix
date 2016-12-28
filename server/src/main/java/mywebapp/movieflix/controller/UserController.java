package mywebapp.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mywebapp.movieflix.entities.User;
import mywebapp.movieflix.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public List<User> showAllUsers(){
		return service.showAllUsers();
	} 
	@RequestMapping(method=RequestMethod.GET,value="/users/{id}")
	public User findOneUser(@PathVariable("id") String uid){
		return service.showOneUser(uid);
	}
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public User createUser(@RequestBody User user){
		return service.createUser(user);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public User updateUser(@PathVariable("id") String uid, @RequestBody User user){
		return service.updateUser(uid, user);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable("id") String uid){
		service.deleteUser(uid);
	}	
	
}

package mywebapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mywebapp.entity.User;
import mywebapp.exception.MovieFlixException;
import mywebapp.facades.MovieFacade;
import mywebapp.services.SecurityService;
import mywebapp.services.UserService;
import mywebapp.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private MovieFacade movieFacade;
	
	private static Logger log = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new mywebapp.entity.User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(userForm);
		
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		log.info("Registration Successul!!!!");
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout, String access) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		try {
			model.addAttribute("json", movieFacade.findAllMovies());
		} catch (MovieFlixException e) {
			e.printStackTrace();
		}
		return "welcome";
	}
}

package mywebapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mywebapp.exception.MovieFlixException;
import mywebapp.facades.ExceptionMessageFacade;
import mywebapp.facades.MovieFacade;

@Controller
public class MovieController {

	@Autowired
	private MovieFacade movieFacade;
	
	@Autowired
	ExceptionMessageFacade exceptionMessageFacade;
	
	private static Logger log = Logger.getLogger(MovieController.class);

	@RequestMapping("/movies")
	@ResponseBody
	public String getMovies() {
		try {
			return movieFacade.findAllMovies();
		} catch (MovieFlixException e) {
			log.debug(e.getCause());
			return exceptionMessageFacade.getCustomExceptionMessageByCode(e.getCode());
		}
	}

}

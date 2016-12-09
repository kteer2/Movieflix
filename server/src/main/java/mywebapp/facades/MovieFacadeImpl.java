package mywebapp.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mywebapp.constants.ExceptionCodeConstants;
import mywebapp.exception.MovieFlixException;
import mywebapp.model.MovieModel;
import mywebapp.services.MovieService;

@Component
public class MovieFacadeImpl implements MovieFacade {

	@Autowired
	private MovieService movieService;

	@Override
	public String findAllMovies() throws MovieFlixException {
		List<MovieModel> movies;
		try {
			movies = movieService.findAllMovies();
			ObjectMapper obj = new ObjectMapper();
			return obj.writeValueAsString(movies);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new MovieFlixException(ExceptionCodeConstants.JSON_PARSING_EXCEPTION_CODE, e);
		}
	}
}

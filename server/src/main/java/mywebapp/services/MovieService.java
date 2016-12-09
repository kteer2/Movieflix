package mywebapp.services;

import java.util.List;

import mywebapp.exception.MovieFlixException;
import mywebapp.model.MovieModel;

public interface MovieService {

	List<MovieModel> findAllMovies() throws MovieFlixException;

}

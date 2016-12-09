package mywebapp.facades;

import mywebapp.exception.MovieFlixException;

public interface MovieFacade {
	
	String findAllMovies() throws  MovieFlixException;

}

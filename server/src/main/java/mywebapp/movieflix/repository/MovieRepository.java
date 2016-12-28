package mywebapp.movieflix.repository;

import java.util.List;

import mywebapp.movieflix.entities.MovieEntity;

public interface MovieRepository {

public List<MovieEntity> showAllMovies();
	
	public MovieEntity showOneMovie(String mid);
	
	public List<MovieEntity> showByTitle(String title);
	
	public List<MovieEntity> showByYear(String year);
	
	public List<MovieEntity> showById(String id);
	
	public List<MovieEntity> showMovieByImdbId(String imdbid);
	
	public List<MovieEntity> showByGenre(String genre);
	
	public List<MovieEntity> showByType(String type);
	
	public List<MovieEntity> showByTopType(String type);
	
	public List<MovieEntity> showByImdbRating();
	
	public List<MovieEntity> showByImdbVotes();
	
	public MovieEntity createMovie(MovieEntity movieEntity);
	
	public MovieEntity updateMovie(MovieEntity movieEntity);
	
	public void deleteMovie(MovieEntity movieEntity);
}

package mywebapp.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywebapp.movieflix.entities.MovieEntity;
import mywebapp.movieflix.exception.ResourceNotFoundException;
import mywebapp.movieflix.exception.ResourceNotInSpecifiedLimit;
import mywebapp.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<MovieEntity> showAllMovies() {
		List<MovieEntity> existing = repository.showAllMovies();
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return repository.showAllMovies();
	}

	@Override
	public MovieEntity showOneMovie(String mid) {
		MovieEntity existing = repository.showOneMovie(mid);
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found with the following reource id " + mid);
		}
		return existing;
	}

	@Override
	@Transactional
	public MovieEntity createMovie(MovieEntity movieEntity) {
		if(movieEntity.getTitle()==null || movieEntity.getType()==null || movieEntity.getGenre()==null || movieEntity.getCountry()==null || movieEntity.getLanguage()==null)
		{
			throw new ResourceNotInSpecifiedLimit("Please fill Title, Type, Genre, Country and Language");
		}			
		return repository.createMovie(movieEntity);
	}

	@Override
	@Transactional
	public MovieEntity updateMovie(String mid, MovieEntity movieEntity) {
		MovieEntity existing = repository.showOneMovie(mid);
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found with the following id "+ mid);
		}
		else if(movieEntity.getTitle()==null || movieEntity.getType()==null || movieEntity.getGenre()==null || movieEntity.getCountry()==null || movieEntity.getLanguage()==null)
		{
			throw new ResourceNotInSpecifiedLimit("Please fill Title, Type, Genre, Country and Language");
		}	
		return repository.updateMovie(movieEntity);
	}

	@Override
	@Transactional
	public void deleteMovie(String mid) {
		MovieEntity existing = repository.showOneMovie(mid);
		if (existing == null) {
			throw new ResourceNotFoundException("Sorry no movies found with the following id "+ mid);
		}
		repository.deleteMovie(existing);
	}

	@Override
	public List<MovieEntity> showByYear(String year) {
		List<MovieEntity> movieEntities = repository.showByYear(year);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}
	
	@Override
	public List<MovieEntity> showById(String id) {
		List<MovieEntity> movieEntities = repository.showById(id);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}
	
	@Override
	public List<MovieEntity> showMovieByImdbId(String imdbid) {
		List<MovieEntity> movieEntities = repository.showMovieByImdbId(imdbid);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByGenre(String genre) {
		List<MovieEntity> movieEntities = repository.showByGenre(genre);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByType(String type) {
		List<MovieEntity> movieEntities = repository.showByType(type);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByImdbRating() {
		return repository.showByImdbRating();
	}

	@Override
	public List<MovieEntity> showByImdbVotes() {
		return repository.showByImdbVotes();
	}

	@Override
	public List<MovieEntity> showByTitle(String title) {
        List<MovieEntity> movieEntities = repository.showByTitle(title);
        if(movieEntities.isEmpty()){
        	throw new ResourceNotFoundException("Sorry, No Movies Found with the following title "+title);
        }
		return movieEntities;
	}

	@Override
	public List<MovieEntity> showByTopType(String type) {
		List<MovieEntity> movieEntities = repository.showByTopType(type);
		if (movieEntities.isEmpty()) {
			throw new ResourceNotFoundException("Sorry no movies found");
		}
		return movieEntities;
	}

}

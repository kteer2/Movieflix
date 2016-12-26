package mywebapp.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mywebapp.movieflix.entities.MovieEntity;
import mywebapp.movieflix.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/movies")
	public List<MovieEntity> showAllMovies(){
		return service.showAllMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/year/{year}")
	public List<MovieEntity> showMovieByYear(@PathVariable("year") String year){
		return service.showByYear(year);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/imdbid/{imdbid}")
	public List<MovieEntity> showMovieByImdbId(@PathVariable("imdbid") String imdbid){
		return service.showMovieByImdbId(imdbid);
	}
	@RequestMapping(method=RequestMethod.GET,value="/movies/genre/{genre}")
	public List<MovieEntity> showMovieByGenre(@PathVariable("genre") String genre){
		return service.showByGenre(genre);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/type/{type}")
	public List<MovieEntity> showMovieByType(@PathVariable("type") String type){
		return service.showByType(type);
	}

	@RequestMapping(method=RequestMethod.GET,value="/movies/top/{type}")
	public List<MovieEntity> showMovieByTopType(@PathVariable("type") String type){
		return service.showByTopType(type);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/imdbvotes")
	public List<MovieEntity> showMovieByImdbVotes(){
		return service.showByImdbVotes();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/imdbrating")
	public List<MovieEntity> showMovieByImdbRating(){
		return service.showByImdbRating();
	}
		
	@RequestMapping(method=RequestMethod.GET,value="/movies/{id}")
	public MovieEntity showOneMovie(@PathVariable("id") String mid){
		return service.showOneMovie(mid);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/movies/title/{title}")
	public List<MovieEntity> showMovieByTitle(@PathVariable("title") String title){
		return service.showByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/admin/movies")	
	public MovieEntity createMovie(@RequestBody MovieEntity movieEntity){
		return service.createMovie(movieEntity);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/admin/movies/{id}")	
	public MovieEntity updateMovie(@PathVariable("id") String mid,@RequestBody MovieEntity movieEntity){
		return service.updateMovie(mid, movieEntity);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/admin/movies/{id}")	
    public void deleteMovie(@PathVariable("id") String mid){
		service.deleteMovie(mid);
    }	
		
}

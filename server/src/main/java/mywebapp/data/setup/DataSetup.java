package mywebapp.data.setup;

import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import mywebapp.entity.Movie;
import mywebapp.exception.MovieFlixException;
import mywebapp.model.MovieModel;
import mywebapp.repository.MovieRepository;
import mywebapp.services.MovieService;

@Component
public class DataSetup {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieRepository movieRepository;
	
	private static Logger log = Logger.getLogger(DataSetup.class);

	@EventListener(ContextRefreshedEvent.class)
	void contextRefreshedEvent() {
		try {
			List<MovieModel> movies = movieService.findAllMovies();
			log.debug("STARTING : Loading Movies Data");
			Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
				for (MovieModel movieModel : movies) {
					Movie destObject = new Movie();
					mapper.map(movieModel, destObject);
					movieRepository.add(destObject);
				}
			log.debug("FINISHED : Loading Movies Data");
		} catch (MovieFlixException e) {
			e.printStackTrace();
		}
	}
}

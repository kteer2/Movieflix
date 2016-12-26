package mywebapp.movieflix.setup;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import mywebapp.movieflix.entities.MovieEntity;
import mywebapp.movieflix.repository.MovieRepository;

@Component
public class DataSetup {
	
	@Autowired
	private MovieRepository repository;
	
	@EventListener(ContextRefreshedEvent.class)
	void contextRefreshedEvent() {
		try {
				ObjectMapper mapper = new ObjectMapper();
				List<MovieEntity> movies = mapper.readValue(new URL("https://learn.egen.io/courses/movielist.json"),
						mapper.getTypeFactory().constructCollectionType(List.class, MovieEntity.class));
				for (MovieEntity movie : movies) {
					repository.createMovie(movie);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	}
}

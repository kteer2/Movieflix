package mywebapp.services;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import mywebapp.constants.ExceptionCodeConstants;
import mywebapp.exception.MovieFlixException;
import mywebapp.model.MovieModel;

@Component("movieService")
@Configuration
@PropertySource(value = "classpath:config.properties")
public class MovieServiceImpl implements MovieService {

	@Value("${movielist.url}")
	private String url;

	@Override
	public List<MovieModel> findAllMovies() throws MovieFlixException {
		return getMoviesList();
	}

	private List<MovieModel> getMoviesList() throws MovieFlixException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new URL(url),
					mapper.getTypeFactory().constructCollectionType(List.class, MovieModel.class));
		} catch (IOException e) {
			throw new MovieFlixException(ExceptionCodeConstants.IO_EXCEPTION_CODE, e);
		}
	}

}

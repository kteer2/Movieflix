package mywebapp.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mywebapp.movieflix.entities.RatingEntity;
import mywebapp.movieflix.exception.ResourceNotInSpecifiedLimit;
import mywebapp.movieflix.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository repository;
	
	@Override
	@Transactional
	public RatingEntity createRating(String userId, String movieId, RatingEntity ratingEntity) {
		double rating = ratingEntity.getRating();
		if (rating<0 || rating>5) {
			throw new ResourceNotInSpecifiedLimit("Rating should be given on a scale of 5");
		}
		return repository.createRating(userId, movieId, ratingEntity);
	}

}

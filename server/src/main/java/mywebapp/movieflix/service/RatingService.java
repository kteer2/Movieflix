package mywebapp.movieflix.service;

import mywebapp.movieflix.entities.RatingEntity;

public interface RatingService {

	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
	
}

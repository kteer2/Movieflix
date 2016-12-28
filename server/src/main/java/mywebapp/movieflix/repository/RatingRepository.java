package mywebapp.movieflix.repository;

import mywebapp.movieflix.entities.RatingEntity;

public interface RatingRepository {

	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
	
}

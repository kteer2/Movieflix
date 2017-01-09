package mywebapp.movieflix.service;

import java.util.List;

import mywebapp.movieflix.entities.CommentEntity;

public interface CommentService {
	public List<CommentEntity> showAll();

	public List<CommentEntity> showCommentsByMovie(String mid);

	public CommentEntity createComment(String userId, String movieId, CommentEntity entity);
}

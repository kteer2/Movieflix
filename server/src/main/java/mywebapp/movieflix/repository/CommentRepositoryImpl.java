package mywebapp.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mywebapp.movieflix.entities.CommentEntity;
import mywebapp.movieflix.entities.MovieEntity;
import mywebapp.movieflix.entities.User;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
		
	@Override
	public List<CommentEntity> showAll() {
		TypedQuery<CommentEntity> query = em.createNamedQuery("CommentEntity.showAllComments",CommentEntity.class);
		return query.getResultList();
	}

	@Override
	public List<CommentEntity> showCommentsByMovie(String mid) {
		TypedQuery<CommentEntity> query = em.createNamedQuery("CommentEntity.showCommentsByMovie",CommentEntity.class);
		query.setParameter("mid", mid);
		return query.getResultList();
	}

	@Override
	public CommentEntity createComment(String userId, String movieId, CommentEntity entity) {
		User user = em.find(User.class, userId);
		MovieEntity movieEntity = em.find(MovieEntity.class, movieId);
		entity.setUser(user);
		entity.setMovieEntity(movieEntity);
		em.persist(entity);
		return entity;
	}

}

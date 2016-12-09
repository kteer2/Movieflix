package mywebapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mywebapp.entity.Movie;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

//	@Override
//	public List<User> findAll() {
//		TypedQuery<User> query = em.createNamedQuery("User.findAllUsers", User.class);
//		return query.getResultList();
//	}
//
//	@Override
//	public User findOne(String username) {
//		return em.find(User.class, username);
//	}
//
//	@Override
//	public User findByUsername(String username) {
//		TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
//		query.setParameter("pUsername", username);
//		List<User> users = query.getResultList();
//		if (users.size() == 1) {
//			return users.get(0);
//		} else {
//			return null;
//		}
//	}

	@Override
	public void add(Movie movie) {
		em.merge(movie);
	}
}
package mywebapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import mywebapp.entity.Role;

@Component
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createNamedQuery("role.findByName", Role.class);
		return query.getResultList();
	}
	
}

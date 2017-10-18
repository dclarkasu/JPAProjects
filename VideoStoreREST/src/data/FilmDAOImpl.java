package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Film;

@Transactional
@Repository
public class FilmDAOImpl implements FilmDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Film> findAll() {
		String query = "SELECT f from Film f";
		return em.createQuery(query, Film.class).getResultList();
		
	}
}

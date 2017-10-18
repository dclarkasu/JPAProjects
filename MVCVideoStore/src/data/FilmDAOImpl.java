package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Film;

@Repository
@Transactional
public class FilmDAOImpl implements FilmDAO {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public Film show(int id) {
		return em.find(Film.class, id);
	}

	@Override
	public List<Film> index() {
		String query = "SELECT f FROM Film f";
		
		List<Film> films = em.createQuery(query, Film.class)
				.getResultList();
		
		if(films.size() != 0) {
			return films;
		} else {
		return null;
		}
	}

	@Override
	public Film update(int id, Film film) {
		if(!film.getTitle().equals("")) {
			
		}
		
		Film f = em.find(Film.class, id);
		f.setTitle(film.getTitle());
		f.setDescription(film.getDescription());
		f.setLang(film.getLang());
		return null;
	}

	@Override
	public boolean destroy(int id) {
		Film f = em.find(Film.class, id);
		em.remove(f);
		
		try {
			(em.find(Film.class, id)).getTitle();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public Film create(Film film) {
		em.persist(film);
		em.flush();
		return film;
	}

}

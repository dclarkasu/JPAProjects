package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Actor;
import entities.Film;

@Repository //discover this as a bean wtih component scan
@Transactional //wraps all methods in a Transaction
public class ActorDAOImpl implements ActorDAO {
	
	@PersistenceContext
	  private EntityManager em;

	@Override
	public Actor create(Actor actor) {
		
		em.persist(actor);
		em.flush();
		
		return actor;
		
	}

	@Override
	public Actor update(int id, Actor actor) {
		
		Actor managedA = em.find(Actor.class, id);//find actor to update
		managedA.setFirstName(actor.getFirstName());//setters update
		managedA.setLastName(actor.getLastName());
		
		return managedA;
	}

	@Override
	public boolean destroy(int id) {
		
		Actor a = em.find(Actor.class, id);//find actor by id to delete
		em.remove(a);//deletes from DB
		
		
		//returns false if the remove did not occur(found a first name)
		//returns true if the find() discovers a null
		try {
		(em.find(Actor.class, id)).getFirstName();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public Actor createActorAndFilm(Actor actor, Film film) {
		
		if(actor.getFilms() == null) {
			actor.setFilms(new ArrayList<Film>());
		}
		
		List<Film> films = actor.getFilms();
		films.add(film);
		actor.setFilms(films);
		
		em.persist(actor);
		em.flush();
		
		return actor;
	}
	
	
	
}
/*Best Way to Write the destroy method*/

//public boolean destroy(int id) {
//    EntityManagerFactory emf = null;
//    EntityManager em = null;
//    
//    try {
//        emf = Persistence.createEntityManagerFactory("VideoStore");
//        em = emf.createEntityManager();
//        
//        em.getTransaction().begin();
//        
//        Actor actor = em.find(Actor.class, id);
//        
//        em.remove(actor);
//        
//        em.getTransaction().commit();
//        
//        if (em.find(Actor.class, id) == null) {
//            
//            return true;
//        }
//    } catch(Exception e) {
//        e.printStackTrace();
////        HANDLE EXCEPTION MAYBE???
//        return false;
//    } finally {
//        em.close();
//        emf.close();
//    }
//    
//    return false;
//    
//}

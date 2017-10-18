package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Actor;
import entities.Film;

public class ActorDAOImpl implements ActorDAO {

	@Override
	public Actor create(Actor actor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(actor);
		em.flush();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return actor;
		
	}

	@Override
	public Actor update(int id, Actor actor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Actor managedA = em.find(Actor.class, id);//find actor to update
		managedA.setFirstName(actor.getFirstName());//setters update
		managedA.setLastName(actor.getLastName());
		
		em.getTransaction().commit();
		
		return managedA;
	}

	@Override
	public boolean destroy(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Actor a = em.find(Actor.class, id);//find actor by id to delete
		em.remove(a);//deletes from DB
		
		em.getTransaction().commit();
		
		//returns false if the remove did not occur(found a first name)
		//returns true if the find() discovers a null
		try {
		(em.find(Actor.class, id)).getFirstName();
			em.close();
			emf.close();
			return false;
		} catch (Exception e) {
			em.close();
			emf.close();
			return true;
		}
	}

	@Override
	public Actor createActorAndFilm(Actor actor, Film film) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		if(actor.getFilms() == null) {
			actor.setFilms(new ArrayList<Film>());
		}
		
		List<Film> films = actor.getFilms();
		films.add(film);
		actor.setFilms(films);
		
		em.getTransaction().begin();
		em.persist(actor);
		em.flush();
		em.getTransaction();
		
		em.close();
		emf.close();
		
		return actor;
	}
	
	//if it does actor.getFilms(), add film param
	// setFIlms(films)
	//getTransaction 
	
	
	
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

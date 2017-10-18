package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data.ActorDAOImpl;
import entities.Actor;
import entities.Film;
import entities.Language;

public class ActorDAOTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		ActorDAOImpl dao = new ActorDAOImpl();
		
		Actor actor = new Actor();
		actor.setFirstName("Dan");
		actor.setLastName("Manny");
		
		Film f = new Film();
		f.setTitle("Space Jam 2: Galactic Jam");
		f.setLang(em.find(Language.class	, 1));
		f.setRentalRate(4.99);
		
		
//		System.out.println(dao.create(actor)); //creates a new actor 
//		System.out.println(dao.update(201, actor)); // updates the actor at the id
//		System.out.println(dao.destroy(202)); //removes actor by id
		
		System.out.println(dao.createActorAndFilm(actor, f));
		System.out.println(dao.destroy(204));
	}

}

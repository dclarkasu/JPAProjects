package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Film;

public class FilmClient {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("VideoStore");
		
		EntityManager em = emf.createEntityManager();
		
		Film f = em.find(Film.class, 5);
		
		System.out.println(f.getTitle());
		System.out.println(f.getDescription());
		System.out.println(f.getReleaseYear());
		
		em.close();
		emf.close();
	}

}

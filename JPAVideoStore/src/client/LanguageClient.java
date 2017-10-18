package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Language;

public class LanguageClient {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("VideoStore");
		
		EntityManager em = emf.createEntityManager();
		
		Language l = em.find(Language.class, 1);
		
		System.out.println(l.getId());
		System.out.println(l.getName());
		
		em.close();
		emf.close();
	}

}

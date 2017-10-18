package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Address;

public class AddressTest {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("VideoStore");
		
		EntityManager em = emf.createEntityManager();
		
		Address a = em.find(Address.class, 5);
		
		System.out.println(a.getStreet());
		System.out.println(a.getCity());
		System.out.println(a.getState());
		
		em.close();
		emf.close();
	}

}

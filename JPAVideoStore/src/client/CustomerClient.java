package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Customer;

public class CustomerClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		
	EntityManager em = emf.createEntityManager();
	
	Customer c = em.find(Customer.class, 1);
	// Does what we did with sql queries. Adds the info I give it and creates a 
	
	System.out.println(c.getFirstName());
	System.out.println(c.getLastName());
	System.out.println(c.getEmail());
	System.out.println(c.getCreatedAt());
	
	em.close();
	emf.close();
	}

}

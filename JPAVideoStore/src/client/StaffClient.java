package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Address;
import entities.Staff;

public class StaffClient {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("VideoStore");
		
		EntityManager em = emf.createEntityManager();
		
		Staff s = em.find(Staff.class, 5);
		
		System.out.println(s.getFirstName());
		System.out.println(s.getLastName());
		System.out.println(s.getEmail());
		
		em.close();
		emf.close();
	}


}

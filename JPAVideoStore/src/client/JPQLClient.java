package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Staff;


public class JPQLClient {
	
	public static void main(String[] args) {
		JPQLClient jpql = new JPQLClient();
		List<Staff> staffPeeps = jpql.getStaffLessThanValue(5);
		for (Staff s : staffPeeps) {
			System.out.println(s.getFirstName() + " " + s.getLastName());
		}
	}
	
	public List<Staff> getStaffLessThanValue(int id) {
		EntityManagerFactory emf;
		EntityManager em = null;
		
		
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		
		String query ="SELECT s FROM Staff AS s WHERE s.id < :id";
		
		List<Staff> staff = em.createQuery(query, Staff.class)
				.setParameter("id", id)
				.getResultList();
		
		
		
		
		em.close();
		emf.close();
		
		return staff;
	}
}

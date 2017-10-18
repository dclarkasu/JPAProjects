package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Customer;
import entities.Rental;
import entities.Store;

public class JPQLLab {
	public static void main(String[] args) {
		JPQLLab j = new JPQLLab();
		List<Customer> customerList;
		List<Store> stores;
		List<Rental> r;
		
		// Returns customers by id range
//		customerList = j.getRangeOfCustomers(100, 110);
//		for (Customer c : customerList) {
//			System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getEmail());
//		}
		
		// Return customers by name
//		 customerList = j.getCustomerByName("Robin", "Hayes");
//		 for (Customer c : customerList) {
//			 System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getEmail());
//		 }
		 
//		 stores = j.getStoresByState("Washington");
//		 for (Store s : stores) {
//			System.out.println(s);
//		}
		
		r = j.getRentalsForCustomerWithCustomerId(1);
		for (Rental rent : r) {
			System.out.println(rent);
		}

	}

	public List<Customer> getRangeOfCustomers(int minId, int maxId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();

		String query = "SELECT c FROM Customer c WHERE c.id " + " BETWEEN :min AND :max";

		List<Customer> customerList = em.createQuery(query, Customer.class)
				.setParameter("min", minId)
				.setParameter("max", maxId).getResultList();

		em.close();
		emf.close();
		return customerList;
	}

	public List<Customer> getCustomerByName(String fname, String lname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();

		String query = "SELECT c FROM Customer c WHERE c.firstName = :fname " + " AND c.lastName = :lname";

		List<Customer> customerList = em.createQuery(query, Customer.class)
				.setParameter("fname", fname)
				.setParameter("lname", lname).getResultList();

		em.close();
		emf.close();

		if (customerList.size() == 0) {
			return null;
		} else {
			return customerList;
		}

	}
	
	public List<Store> getStoresByState(String state) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();

		String query = "SELECT s FROM Store AS s WHERE s.address.state = :state";

		List<Store> stores = em.createQuery(query, Store.class)
				.setParameter("state", state)
				.getResultList();

//		SELECT * FROM store s
//	    -> JOIN address a ON s.address_id = a.id
//	    -> WHERE a.state_province = 'Washington';

		em.close();
		emf.close();

		return stores;
	}

	public List<Rental> getRentalsForCustomerWithCustomerId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT r FROM Rental r WHERE r.cust.id = :id";
		
		List<Rental> r = em.createQuery(query, Rental.class)
				.setParameter("id", id)
				.getResultList();
		
		em.close();
		emf.close();
		
		return r;
	}

}

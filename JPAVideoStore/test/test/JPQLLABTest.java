package test;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.JPQLLab;
import entities.Customer;
import entities.Rental;
import entities.Store;


public class JPQLLABTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	JPQLLab jpql;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		jpql = new JPQLLab();
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		jpql = null;
	}
	
	@Test
	public void test_Get_Range_Of_Customers() {
		List<Customer> c = jpql.getRangeOfCustomers(1, 5);
		assertEquals(c.size(), 5);
		assertEquals(c.get(0).getId(), 1);
	}
	
	@Test
	public void test_Get_Customers_By_Name() {
		List<Customer> c = jpql.getCustomerByName("Robin", "Hayes");
		assertEquals(c.get(0).getFirstName(), "Robin");
		assertEquals(c.get(0).getLastName(), "Hayes");
	}
	
	@Test
	public void test_Get_Store_By_State() {
		List<Store> s = jpql.getStoresByState("Washington");
		assertEquals(s.get(0).getAddress().getState(), "Washington");
	}
	
	@Test
	public void test_Get_Rentals_By_Customer_Id() {
		List<Rental> r = jpql.getRentalsForCustomerWithCustomerId(1);
		assertTrue(r.size() > 1);
	}
}
package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Rental;

public class RentalTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Rental rent;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}
	
	@Test
	public void testRentalFieldMappings() {
		rent = em.find(Rental.class, 1);
		assertEquals(rent.getRentalDate().toString(), "2014-05-24" );
	}
	
	@Test
	public void test_Staff_Mapping_To_Rental() {
		rent = em.find(Rental.class, 1);
		assertEquals(rent.getStaff().getFirstName(), "William");
		assertEquals(rent.getStaff().getLastName(), "Tingvold");
	}
	
	@Test
	public void test_Many_To_One_With_Customer() {
		rent = em.find(Rental.class, 1);
		assertEquals(rent.getCust().getFirstName(), "Charlotte");
		assertEquals(rent.getCust().getLastName(), "Hunter");
	}

}

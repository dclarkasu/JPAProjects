package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Address;
import entities.Country;

public class AddressTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Address add = new Address();
	
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
	public void testAddressFieldMappings() {
		add = em.find(Address.class, 1);
		assertEquals(add.getStreet(), "47 MySakila Drive");
		assertEquals(add.getCity(), "Lethbridge");
		assertEquals(add.getState(), "Alberta");
	}
	
	@Test
	public void test_country_association() {
		add = em.find(Address.class, 1);
		//Stored in an additional variable, not necessary
//		Country country = add.getCountry();
//		String code = country.getCountryCode();
		assertEquals(add.getCountry().getCountryCode(), "CA");
	}
}

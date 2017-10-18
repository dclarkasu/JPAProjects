
package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Staff;

public class StaffTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Staff staff;
	
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
	public void testStaffFieldMappings() {
		staff = em.find(Staff.class, 1);
		assertEquals(staff.getFirstName(), "Larry");
		assertEquals(staff.getEmail(), "larry.kong@example.com");
	}
	
	@Test
	public void test_Address_Field_mapping() {
		staff = em.find(Staff.class, 1);
		assertEquals(staff.getAddress().getCity(), "Las Vegas");
		assertEquals(staff.getAddress().getPostalCode(), "89191");
	}
}

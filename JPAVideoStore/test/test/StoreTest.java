package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Address;
import entities.Staff;
import entities.Store;

public class StoreTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Store store;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		store = em.find(Store.class, 1);

	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}
	
	@Test
	public void test_Store_rltnshp_and_city() {
		Address address = store.getAddress();
		assertEquals(address.getStreet(), "264 Blanchard Ave");
		assertEquals(address.getState(), "Washington");
		assertEquals(address.getCity(), "Seattle");
	}
	
	@Test
	public void test_One_To_Many_With_Store() {
		assertEquals(store.getCustomers().size(), 74);
		/*SELECT * FROM customer c
	    -> JOIN store s ON c.store_id = s.id 
	    -> WHERE s.id = 1;*/
	}
	
	@Test
	public void test_One_To_One_Store_Manager() {
		Staff staff = store.getManager();
		assertEquals(staff.getFirstName(), "Dutch");
		assertEquals(staff.getLastName(), "LaFever");
		
//		SELECT s.first_name, s.last_name FROM staff s
//	    -> JOIN store st ON st.manager_id = s.id
//	    -> WHERE st.id = 1;
	}
	
	@Test
	public void test_Many_To_Many_With_Film() {
		assertNotNull(store.getFilms());
		assertEquals(store.getFilms().size(), 2270);
	}
	
	@Test
	public void test_One_To_Many_With_Inventory_Item() {
		assertEquals(store.getInventoryList().size(), 2270);
		assertNotNull(store.getInventoryList());
	}
}

package test;
import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Address;
import entities.Customer;


public class CustomerTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Customer cust;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		cust = em.find(Customer.class, 1);

	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void testCustomerFieldMappings() {
		assertEquals(cust.getFirstName(), "Mary");
		assertEquals(cust.getLastName(), "Smithers");
		assertEquals(cust.getEmail(), "MARY.SMITH@sdvidcustomer.org");
	}
	
	@Test
	public void test_customer_temporal() {
	assertEquals(cust.getCreatedAt().toString(), "2014-05-25");
	}
	
	  @Test
	  public void test_address_association() {
	     Customer cust = em.find(Customer.class, 2);
	     Address address = cust.getAddress();
	     assertEquals("1121 Loja Avenue", address.getStreet());
	     assertEquals("", address.getStreet2());
	     assertEquals("San Bernardino", address.getCity());
	     assertEquals("17886", address.getPostalCode());
	  }
	  
	  @Test
	  public void test_One_To_Many_With_Rental() {
		  Customer cust = em.find(Customer.class, 1);
		  assertEquals(cust.getRentals().size(), 95);
		  assertEquals(cust.getRentals().isEmpty(), false);
	  }
	  
	  @Test
	  public void test_Many_To_One_With_Store() {
		  Customer cust = em.find(Customer.class, 1);
		  assertEquals(cust.getStore().getId(), 7);
		  assertEquals(cust.getStore().getAddress().getCity(), "Los Angeles");
	  }
}

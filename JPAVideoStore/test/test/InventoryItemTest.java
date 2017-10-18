package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.InventoryItem;
import entities.MediaCondition;

public class InventoryItemTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	InventoryItem ii;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		ii = em.find(InventoryItem.class, 1);;
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		ii = null;
	}
	
	@Test
	public void test_Inventory_Item_And_Media_Condition_Mapping() {
		assertEquals(ii.getCondition(), MediaCondition.Used);
	}

}

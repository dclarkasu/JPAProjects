package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.ManyToManyLab;
import entities.Film;

public class ManyTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	ManyToManyLab many;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		many = new ManyToManyLab();
	}
	;
	@After
	public void tearDown() {
		em.close();
		emf.close();
		many = null;
	}
	
	@Test
	public void test_Get_Films_For_Actors_With_Id() {
		List<Film> f = many.getFilmsForActorsWithId(1);
		assertTrue(f.size() > 1);
		assertEquals(f.get(0).getTitle(), "ACADEMY DINOSAUR" );
		assertEquals(f.get(0).getId(), 1 );
	}
	
	@Test
	public void test_Get_Number_Of_Films_For_Category_By_Name() {
		int i = many.getNumberOfFilmsForCategoryWithName("Action");
		assertEquals(i, 64);
	}
	
	@Test
	public void test_Check_Film_Inventory_Item_For_Store_By_Id() {
		// test method from ManyToMany
	}

}

package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Category;

public class CategoryTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Category cat;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("VideoStore");
		em = emf.createEntityManager();
		cat = new Category();
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		cat = null;
	}
	
	@Test
	public void test_Get_Name() {
		cat = em.find(Category.class, 1);
		assertEquals(cat.getName(), "Action");
	}
	
	@Test
	public void test_Many_To_Many_With_Film() {
		cat = em.find(Category.class, 1);
		assertNotNull(cat.getFilms());
		assertEquals(cat.getFilms().size(), 64);
		assertEquals(cat.getFilms().get(0).getActors().get(0).getFirstName(), "Johnny");
	}

}

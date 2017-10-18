package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Actor;
import entities.Film;

public class ActorTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Film film;
	
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
	public void test_Many_To_Many_Get_Actors() {
		Actor a = em.find(Actor.class, 1);
		assertNotNull(a.getFilms());
		assertEquals(a.getFilms().size(), 19);
		assertEquals(a.getFilms().get(0).getActors().get(0).getFirstName(), "Penelope");
	}

}

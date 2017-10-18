package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Film;
import entities.Language;

public class LanguageTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Language lang;
	
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
	public void testLanguageFieldMappings() {
		lang = em.find(Language.class, 1);
		assertEquals(lang.getId(), 1);
		assertEquals(lang.getName(), "English");
	}
	
	@Test
	public void test_Film_mapping() {
		Language l = em.find(Language.class, 1);
		assertEquals(l.getFilms().size(), 983);
	}
}

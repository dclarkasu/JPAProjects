package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Actor;
import entities.Category;
import entities.Film;
import entities.InventoryItem;

public class ManyToManyLab {
	
	public static void main(String[] args) {
		ManyToManyLab many = new ManyToManyLab();
		
		List<Film> f = many.getFilmsForActorsWithId(1);
		for (Film film : f) {
			System.out.println(film);
		}
}
	
	//Return the list of films associated with that actor.
	public List<Film> getFilmsForActorsWithId(int id){ 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT a FROM Actor AS a JOIN FETCH a.films WHERE a.id = :id";
		
		List<Actor> actors = em.createQuery(query, Actor.class)
				.setParameter("id", id)
				.getResultList();

		if (actors.size() != 0) {
			List<Film> f = actors.get(0).getFilms();
			em.close();
			emf.close();
			return f;
		} else {
			return null;
		}
		
	}
	
	//lists how many Films contain a Category in the provided category.
	public int getNumberOfFilmsForCategoryWithName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT c FROM Category c JOIN FETCH c.films WHERE c.name = :name";
		
		List<Category> c = em.createQuery(query, Category.class)
				.setParameter("name", name)
				.getResultList();
		
		if(c.size() != 0) {
			int f = c.get(0).getFilms().size();
			em.close();
			emf.close();
			return f;
		} else {
			return 0;
		}
	}
	
	public int checkFilmInventoryItemsForStoreById(int id, String title) { 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT i FROM InventoryItem i WHERE i.store.id = :id AND i.film.title = :title ";
		
		
		List<InventoryItem> ii = em.createQuery(query, InventoryItem.class)
				.setParameter("id",	id)
				.getResultList();
		
		//ii.size() ....
		if(ii.size() != 0) {
			
		}
		
		return 0;
	}
	
	//SELECT r.item.film FROM rental r WHERE r.customer.id = :id
	// try catch with createQuery, id param, returning a list of films
	
//	public int checkFilmInventoryForStoryById(int id, String title) {
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        int inventoryCount = 0;
//        
//        try {
//            emf = Persistence.createEntityManagerFactory("VideoStore");
//            em = emf.createEntityManager();
//            
//            String q = "SELECT i FROM InventoryItem i "
//                      + "WHERE i.store.id = :id "
//                     + "AND i.film.title = :title";
//            
//            List<InventoryItem> items = em.createQuery(q, InventoryItem.class)
//                        .setParameter("title", title)
//                        .setParameter("id", id)
//                        .getResultList();
//            
//            inventoryCount = items.size();
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//        return inventoryCount;
//    }
//    
//    public List<Film> getFilmsRentedForCustomerWithId(int id) {
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        List<Film> films = null;
//        
//        try {
//            emf = Persistence.createEntityManagerFactory("VideoStore");
//            em = emf.createEntityManager();
//            
//            String q = "SELECT r.item.film FROM Rental r WHERE r.customer.id = :id";
//            films = em.createQuery(q, Film.class)
//                        .setParameter("id", id)
//                        .getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//        return films;
//    }
}

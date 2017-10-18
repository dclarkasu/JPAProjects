package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Address;

@Repository
@Transactional//Automatically starts and ends transactions for each method
public class AddressDAOImpl implements AddressDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Address> getAll() {
		String query = "SELECT a FROM Address a";
		return em.createQuery(query, Address.class)
				.getResultList();
		
	}

	@Override
	public Address getById(int id) {
		return em.find(Address.class, id);
	}

	@Override
	public Address create(String addressJSON) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Address mappedAddress = mapper.readValue(addressJSON, Address.class);
			//persist in DB
			em.persist(mappedAddress);
			//make sure we have the up to date version locally
			em.flush();
			return mappedAddress;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//delete = pass an id and call em.remove()
	
	
	

}

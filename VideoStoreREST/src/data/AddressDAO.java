package data;

import java.util.List;

import entities.Address;

public interface AddressDAO {
	
	public List<Address> getAll();
	public Address getById(int id);
	public Address create(String addressJSON);

}

package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //delegating creation of id to mysql
	private int id;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy = "store" )
	private List<Customer> customers;
	
	@OneToOne
	@JoinColumn(name="manager_id")
	private Staff manager;
	
	@ManyToMany
	@JoinTable(name="inventory_item",
	joinColumns=@JoinColumn(name="store_id"),
	inverseJoinColumns=@JoinColumn(name="film_id")
	)
	private List<Film> films;
	
	@OneToMany(mappedBy="store")
	private List<InventoryItem> inventoryList;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public Staff getManager() {
		return manager;
	}
	public void setManager(Staff manager) {
		this.manager = manager;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public List<InventoryItem> getInventoryList() {
		return inventoryList;
	}
	public void setInventoryList(List<InventoryItem> inventoryList) {
		this.inventoryList = inventoryList;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", address=" + address + "]"; // customers list could create a stack overflow
	}
	
	

}

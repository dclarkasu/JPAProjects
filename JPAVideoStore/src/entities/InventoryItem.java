package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory_item")
public class InventoryItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name="media_condition")
	private MediaCondition condition;
	@ManyToOne //owning side
	@JoinColumn(name="film_id")
	private Film film;
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
	//@OneToMany(mappedBy="items")
	//private List<Rental> rentals
	
	
	
	
	public MediaCondition getCondition() {
		return condition;
	}
	public void setCondition(MediaCondition condition) {
		this.condition = condition;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", condition=" + condition + "]";
	}
	
	
}

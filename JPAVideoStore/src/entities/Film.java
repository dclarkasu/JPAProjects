package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@Column(name = "release_year")
	private int releaseYear;
	@Column(name = "rental_rate")
	private double rentalRate;
	private int length;
	@Column(name = "replacement_cost")
	private double replacementCost;
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@JsonManagedReference(value="actorToLanguage")
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language lang;
	
	@JsonManagedReference(value="actorToFilm")
	@ManyToMany(mappedBy="films", fetch=FetchType.EAGER)
	private List<Actor> actors;
	
	@JsonIgnore
	@ManyToMany(mappedBy="films")
	private List<Category> categories;
	
	@JsonIgnore
	@ManyToMany(mappedBy="films")
	private List<Store> stores;
	
	@JsonIgnore
	@OneToMany(mappedBy="film") //non-owning side
	private List<InventoryItem> copies;
	
	//Gets and Sets
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getTitle() {
		return title;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<InventoryItem> getCopies() {
		return copies;
	}

	public void setCopies(List<InventoryItem> copies) {
		this.copies = copies;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost + "]";
	}

}

package rs.ac.singidunum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
	private Place place;

	public Address() {
		super();
		
	}

	public Address(Long id, String street, int number, Place place) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.place = place;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}

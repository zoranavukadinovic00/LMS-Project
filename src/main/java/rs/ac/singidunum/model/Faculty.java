package rs.ac.singidunum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Faculty {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
	private University university;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dean_id")
	private User dean;
	
	@Column(name = "contact", nullable = false)
	private String contact;
	
	
	@Column(name = "description", nullable = false)
	private String description;


	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Faculty(Long id, String name, University university, Address address, User dean, String contact,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
		this.address = address;
		this.dean = dean;
		this.contact = contact;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public User getDean() {
		return dean;
	}


	public void setDean(User dean) {
		this.dean = dean;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

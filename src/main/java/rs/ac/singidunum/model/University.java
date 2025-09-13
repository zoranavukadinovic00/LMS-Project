package rs.ac.singidunum.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "university")
public class University {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rector_id")
	private User rector;
	
	@Column(name = "contact", nullable = false)
	private String contact;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "date_of_establishment", nullable = false)
	private LocalDate  dateOfEstablishment;

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(Long id, String name, Address address, User rector, String contact, String description,
			LocalDate dateOfEstablishment) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rector = rector;
		this.contact = contact;
		this.description = description;
		this.dateOfEstablishment = dateOfEstablishment;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getRector() {
		return rector;
	}

	public void setRector(User rector) {
		this.rector = rector;
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

	public LocalDate getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(LocalDate dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	

	
	
	

}

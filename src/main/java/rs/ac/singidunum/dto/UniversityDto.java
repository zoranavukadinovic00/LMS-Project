package rs.ac.singidunum.dto;

import java.time.LocalDate;

import rs.ac.singidunum.model.University;

public class UniversityDto {
    private Long id;
    private String name;
    private String address; 
    private String contact;
    private String description;
    private LocalDate dateOfEstablishment;
    private String rectorName; 
    private String rectorEmail;
    
    
    private AddressDto addressDetails;
    private RectorDto rectorDetails;

    public static class AddressDto {
        public String street;
        public String number;
        public String city;
        public String country;

        public AddressDto() {}

        public AddressDto(String street, String number, String city, String country) {
            this.street = street;
            this.number = number;
            this.city = city;
            this.country = country;
        }

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

        
    }

    public static class RectorDto {
        public Long id;
        public String fullName;
        public String email;

        public RectorDto() {}

        public RectorDto(Long id, String fullName, String email) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
        }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

        
    }

    public UniversityDto() {}

    public UniversityDto(University u) {
        this.id = u.getId();
        this.name = u.getName();
        this.contact = u.getContact();
        this.description = u.getDescription();
        this.dateOfEstablishment = u.getDateOfEstablishment();

        
        if (u.getAddress() != null) {
            this.addressDetails = new AddressDto();
            this.addressDetails.street = u.getAddress().getStreet();
            this.addressDetails.number = String.valueOf(u.getAddress().getNumber());
            this.addressDetails.city = u.getAddress().getPlace().getName();
            this.addressDetails.country = u.getAddress().getPlace().getCountry().getName();
            
            
            this.address = String.format("%s %s, %s, %s", 
                this.addressDetails.street, 
                this.addressDetails.number, 
                this.addressDetails.city, 
                this.addressDetails.country);
        }

        
        if (u.getRector() != null) {
            this.rectorDetails = new RectorDto();
            this.rectorDetails.id = u.getRector().getId();
            this.rectorDetails.fullName = u.getRector().getName() + " " + u.getRector().getSurname();
            this.rectorDetails.email = u.getRector().getEmail();
            
            
            this.rectorName = this.rectorDetails.fullName;
            this.rectorEmail = this.rectorDetails.email;
        }
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRectorName() {
		return rectorName;
	}

	public void setRectorName(String rectorName) {
		this.rectorName = rectorName;
	}

	public String getRectorEmail() {
		return rectorEmail;
	}

	public void setRectorEmail(String rectorEmail) {
		this.rectorEmail = rectorEmail;
	}

	public AddressDto getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDto addressDetails) {
		this.addressDetails = addressDetails;
	}

	public RectorDto getRectorDetails() {
		return rectorDetails;
	}

	public void setRectorDetails(RectorDto rectorDetails) {
		this.rectorDetails = rectorDetails;
	}

    
}
package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Faculty;

public class FacultyDto {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String description;
    private String deanName;
    private String deanEmail;
     

    private AddressDto addressDetails;
    private DeanDto deanDetails;

    public static class AddressDto {
        private String street;
        private String number;
        private String city;
        private String country;

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

    public static class DeanDto {
        private Long id;
        private String fullName;
        private String email;

        public DeanDto() {}

        public DeanDto(Long id, String fullName, String email) {
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

    public FacultyDto() {}

    public FacultyDto(Faculty f) {
        if (f == null) return;

        this.id = f.getId();
        this.name = f.getName();
        this.contact = f.getContact();
        this.description = f.getDescription();

       
        

        
        if (f.getAddress() != null) {
            this.addressDetails = new AddressDto();
            this.addressDetails.street = f.getAddress().getStreet();
            this.addressDetails.number = String.valueOf(f.getAddress().getNumber());
            
            if (f.getAddress().getPlace() != null) {
                this.addressDetails.city = f.getAddress().getPlace().getName();
                if (f.getAddress().getPlace().getCountry() != null) {
                    this.addressDetails.country = f.getAddress().getPlace().getCountry().getName();
                }
            }

            
            StringBuilder addressBuilder = new StringBuilder();
            if (!isBlank(this.addressDetails.street)) {
                addressBuilder.append(this.addressDetails.street);
            }
            if (!isBlank(this.addressDetails.number)) {
                if (addressBuilder.length() > 0) {
                    addressBuilder.append(" ");
                }
                addressBuilder.append(this.addressDetails.number);
            }
            if (!isBlank(this.addressDetails.city)) {
                if (addressBuilder.length() > 0) {
                    addressBuilder.append(", ");
                }
                addressBuilder.append(this.addressDetails.city);
            }
            if (!isBlank(this.addressDetails.country)) {
                if (addressBuilder.length() > 0) {
                    addressBuilder.append(", ");
                }
                addressBuilder.append(this.addressDetails.country);
            }
            
            this.address = addressBuilder.toString();
        }

        // Dean (null-safe)
        if (f.getDean() != null) {
            this.deanDetails = new DeanDto();
            this.deanDetails.id = f.getDean().getId();
            String fullName = joinNames(f.getDean().getName(), f.getDean().getSurname());
            this.deanDetails.fullName = fullName;
            this.deanDetails.email = f.getDean().getEmail();

            this.deanName = fullName;
            this.deanEmail = this.deanDetails.email;
        }
    }

    private static boolean isBlank(String s) { 
        return s == null || s.trim().isEmpty(); 
    }
    
    private static String joinNames(String first, String last) {
        if (isBlank(first) && isBlank(last)) return null;
        if (isBlank(first)) return last.trim();
        if (isBlank(last)) return first.trim();
        return first.trim() + " " + last.trim();
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

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public String getDeanEmail() {
        return deanEmail;
    }

    public void setDeanEmail(String deanEmail) {
        this.deanEmail = deanEmail;
    }

    

    public AddressDto getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDto addressDetails) {
        this.addressDetails = addressDetails;
    }

    public DeanDto getDeanDetails() {
        return deanDetails;
    }

    public void setDeanDetails(DeanDto deanDetails) {
        this.deanDetails = deanDetails;
    }
}
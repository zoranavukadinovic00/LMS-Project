package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.User;

public class UserDto {
	
	
	private Long id;
	private String username;
	private String email;
	private String jmbg;
	private String name;
	private String surname;
	private String biography;
	
	
	public UserDto() {
		super();
	}


	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.jmbg = user.getJmbg();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.biography = user.getBiography();
		
	
		
		
		
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}

}

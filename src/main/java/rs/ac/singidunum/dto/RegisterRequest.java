package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.enums.UserType;

public class RegisterRequest {
    
    private Long id;

    private String username;

    private String password;

    private String email;

    private String jmbg;

    private String name;

    private String surname;

    private String biography;
    
    // KLJUČNO: Admin koristi ovo polje da odredi ulogu
    private UserType type; 
    
    

    public RegisterRequest() {
        super();
    }

    
    public RegisterRequest(Long id, String username, String password, String email, String jmbg, String name, String surname,
            String biography, UserType type) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}

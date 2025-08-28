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
public class StudyProgram {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
	private Faculty faculty;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
	private User manager;


	public StudyProgram() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudyProgram(Long id, String name, Faculty faculty, String description, User manager) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.description = description;
		this.manager = manager;
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


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getManager() {
		return manager;
	}


	public void setManager(User manager) {
		this.manager = manager;
	}
	
	
}

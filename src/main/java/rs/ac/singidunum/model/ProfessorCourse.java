package rs.ac.singidunum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProfessorCourse {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
	private User professor;
	
	

	public ProfessorCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ProfessorCourse(Long id, Course course, User professor) {
		super();
		this.id = id;
		this.course = course;
		this.professor = professor;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getProfessor() {
		return professor;
	}

	public void setProfessor(User professor) {
		this.professor = professor;
	}
	
}

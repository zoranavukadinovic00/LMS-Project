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
public class TermTopic {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "term_number", nullable = false)
	private  int termNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
	private Course course;

	public TermTopic() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TermTopic(Long id, String description, int termNumber, Course course) {
		super();
		this.id = id;
		this.description = description;
		this.termNumber = termNumber;
		this.course = course;
	}


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getTermNumber() {
		return termNumber;
	}


	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}

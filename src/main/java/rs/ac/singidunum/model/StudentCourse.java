package rs.ac.singidunum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rs.ac.singidunum.model.enums.EnrollmentStatus;

@Entity
public class StudentCourse {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
	private User student;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
	private EnrollmentStatus status;
	
	@Column(name = "grade", nullable = true)
	private Integer grade;
	
	@Column(name = "points", nullable = false)
	private int points;
	
	@Column(name = "numer_of_exam_applications", nullable = false)
	private int numberOfExamApplications;
	
	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(Long id, User student, Course course, EnrollmentStatus status, Integer grade, int points,
			int numberOfExamApplications) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.status = status;
		this.grade = grade;
		this.points = points;
		this.numberOfExamApplications = numberOfExamApplications;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public EnrollmentStatus getStatus() {
		return status;
	}

	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNumberOfExamApplications() {
		return numberOfExamApplications;
	}

	public void setNumberOfExamApplications(int numberOfExamApplications) {
		this.numberOfExamApplications = numberOfExamApplications;
	}
	
	
}

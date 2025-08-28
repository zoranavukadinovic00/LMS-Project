package rs.ac.singidunum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentOnYear {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
	private User student;
	
	@Column(name = "date_of_enrollment", nullable = false)
	private int dateOfEnrollment;
	
	@Column(name = "index_number", nullable = false)
	private int indexNumber;
	
	@Column(name = "year", nullable = false)
	private int year;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_program_id")
	private StudyProgram studyProgram;

	public StudentOnYear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentOnYear(Long id, User student, int dateOfEnrollment, int indexNumber, int year,
			StudyProgram studyProgram) {
		super();
		this.id = id;
		this.student = student;
		this.dateOfEnrollment = dateOfEnrollment;
		this.indexNumber = indexNumber;
		this.year = year;
		this.studyProgram = studyProgram;
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

	public int getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(int dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	
}

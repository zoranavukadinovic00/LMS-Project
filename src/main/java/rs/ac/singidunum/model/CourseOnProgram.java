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
public class CourseOnProgram {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_program_id")
	private StudyProgram studyProgram;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name = "year", nullable = false)
	private int year;

	public CourseOnProgram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseOnProgram(Long id, StudyProgram studyProgram, Course course, int year) {
		super();
		this.id = id;
		this.studyProgram = studyProgram;
		this.course = course;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}

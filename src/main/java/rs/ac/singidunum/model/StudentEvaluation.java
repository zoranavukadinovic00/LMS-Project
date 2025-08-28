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
public class StudentEvaluation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "points", nullable = false)
	private int points;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_course_id")
	private StudentCourse studentCourse;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evaluation_instrument_id")
	private EvaluationInstrument evaluationInstrument;

	public StudentEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEvaluation(Long id, int points, StudentCourse studentCourse,
			EvaluationInstrument evaluationInstrument) {
		super();
		this.id = id;
		this.points = points;
		this.studentCourse = studentCourse;
		this.evaluationInstrument = evaluationInstrument;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}

	public EvaluationInstrument getEvaluationInstrument() {
		return evaluationInstrument;
	}

	public void setEvaluationInstrument(EvaluationInstrument evaluationInstrument) {
		this.evaluationInstrument = evaluationInstrument;
	}
	
	
	

}

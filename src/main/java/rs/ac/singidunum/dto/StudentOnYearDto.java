package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.StudentOnYear;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.model.User;

public class StudentOnYearDto {

	
	private Long id;
	private User student;
	private int dateOfEnrollment;
	private int indexNumber;
	private int year;
	private StudyProgram studyProgram;
	private String index;
	private Double averageGrade;
	
	public StudentOnYearDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentOnYearDto(Long id, User student, int dateOfEnrollment, int indexNumber, int year,
			StudyProgram studyProgram, String index, Double averageGrade) {
		super();
		this.id = id;
		this.student = student;
		this.dateOfEnrollment = dateOfEnrollment;
		this.indexNumber = indexNumber;
		this.year = year;
		this.studyProgram = studyProgram;
		this.index = index;
		this.averageGrade = averageGrade;
		}
	
	public StudentOnYearDto(StudentOnYear s) {
	    this.id = s.getId();
	    this.student = s.getStudent();
	    this.dateOfEnrollment = s.getDateOfEnrollment();
	    this.indexNumber = s.getIndexNumber();
	    this.year = s.getYear();
	    this.studyProgram = s.getStudyProgram();
	    this.index = s.getIndex();
	    this.averageGrade = s.getAverageGrade();
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}

	

	

	
	
}

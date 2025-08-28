package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.EnrollmentStatus;

public class StudentCourseDto {

	private Long id;
	private String studentFullName;
	private String courseName;
	private int coursesEspbPoints;
	private EnrollmentStatus status;
	private Integer grade;
	private int points;

	private int numberOfExamApplications;
	
	
	public StudentCourseDto(StudentCourse studentCourse) {
		id = studentCourse.getId();
		User user = studentCourse.getStudent();
		studentFullName = user.getName() + " " + user.getSurname();
		courseName = studentCourse.getCourse().getName();
		coursesEspbPoints = studentCourse.getCourse().getEspbPoints();
		
		status = studentCourse.getStatus();
		grade = studentCourse.getGrade();
		points = studentCourse.getPoints();
		numberOfExamApplications = studentCourse.getNumberOfExamApplications();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentFullName() {
		return studentFullName;
	}


	public void setStudentFullName(String studentFullName) {
		this.studentFullName = studentFullName;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCoursesEspbPoints() {
		return coursesEspbPoints;
	}


	public void setCoursesEspbPoints(int coursesEspbPoints) {
		this.coursesEspbPoints = coursesEspbPoints;
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

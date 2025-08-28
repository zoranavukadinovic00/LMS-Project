package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.enums.ExamApplicationStatus;

public class ExamApplicationDto {
	
	private Long id;

	private Long courseId;

	private Long studentId;

	private ExamApplicationStatus status;

	private LocalDateTime applicationDate;

	private int points;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public ExamApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ExamApplicationStatus status) {
		this.status = status;
	}

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}


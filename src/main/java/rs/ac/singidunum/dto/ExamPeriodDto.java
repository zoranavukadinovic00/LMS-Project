package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.ExamPeriod;

public class ExamPeriodDto {
	
	private Long id;
	
	private Long courseId;
	private String courseName;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate = LocalDateTime.now();

	public ExamPeriodDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ExamPeriodDto(ExamPeriod examPeriod) {
		this.id = examPeriod.getId();
		this.courseId = examPeriod.getCourse().getId();
		this.startDate = examPeriod.getStartDate();
		this.endDate = examPeriod.getEndDate();
		this.courseName = examPeriod.getCourse().getName();
    }

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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}

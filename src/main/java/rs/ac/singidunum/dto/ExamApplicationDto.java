package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.ExamApplication;

public class ExamApplicationDto {
	
	private Long id;
    private Long studentId;
    private String studentName;
    private String studentIndex;
    private Long courseId;
    private String courseName;
    private Long termId;
    private String termName;
    private LocalDateTime applicationDate;
    private int points;
    private String status;

    public ExamApplicationDto() {}

    public ExamApplicationDto(ExamApplication app) {
        this.id = app.getId();
        this.studentId = app.getStudent().getId();
        this.studentName = app.getStudent().getName() + " " + app.getStudent().getSurname();
        this.studentIndex = String.valueOf(app.getStudent().getId());
        this.courseId = app.getCourse().getId();
        this.courseName = app.getCourse().getName();
        this.termId = app.getExamTerm().getId();
        this.termName = app.getExamTerm().getName();
        this.applicationDate = app.getApplicationDate();
        this.points = app.getPoints();
        this.status = app.getStatus().name();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentIndex() {
		return studentIndex;
	}

	public void setStudentIndex(String studentIndex) {
		this.studentIndex = studentIndex;
	}
	
    
}


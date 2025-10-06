package rs.ac.singidunum.dto;

import java.time.LocalDate;

import rs.ac.singidunum.model.ExamGrade;

public class ExamGradeDto {
	
	private Long id;
    private Long studentId;
    private String studentName;
    private Long courseId;
    private String courseName;
    private Long termId;
    private int grade;
    private LocalDate dateGraded;

    public ExamGradeDto() {}

    public ExamGradeDto(ExamGrade e) {
        this.id = e.getId();
        this.studentId = e.getStudent().getId();
        this.studentName = e.getStudent().getName() + " " + e.getStudent().getSurname();
        this.courseId = e.getCourse().getId();
        this.courseName = e.getCourse().getName();
        this.termId = e.getExamTerm().getId();
        this.grade = e.getGrade();
        this.dateGraded = e.getDateGraded();
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public LocalDate getDateGraded() {
		return dateGraded;
	}

	public void setDateGraded(LocalDate dateGraded) {
		this.dateGraded = dateGraded;
	}
    
}

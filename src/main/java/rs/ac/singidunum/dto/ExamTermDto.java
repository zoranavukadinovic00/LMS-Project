package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.ExamTerm;

public class ExamTermDto {
	
	private Long id;
    private String name;
    private LocalDateTime examDate;
    private Long periodId;
    private String periodName;
    private Long courseId;
    private String courseName;

    public ExamTermDto() {}

    public ExamTermDto(ExamTerm term) {
        this.id = term.getId();
        this.name = term.getName();
        this.examDate = term.getExamDate();
        if (term.getExamPeriod() != null) {
            this.periodId = term.getExamPeriod().getId();
            this.periodName = term.getExamPeriod().getName();
        }
        if (term.getCourse() != null) {
            this.courseId = term.getCourse().getId();
            this.courseName = term.getCourse().getName();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
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
}

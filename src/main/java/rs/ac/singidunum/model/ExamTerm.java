package rs.ac.singidunum.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ExamTerm {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "exam_date", nullable = false)
    private LocalDateTime examDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_period_id", nullable = false)
    private ExamPeriod examPeriod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public ExamTerm() {
        super();
    }

    public ExamTerm(Long id, String name, LocalDateTime examDate, ExamPeriod examPeriod, Course course) {
        super();
        this.id = id;
        this.name = name;
        this.examDate = examDate;
        this.examPeriod = examPeriod;
        this.course = course;
    }

    public ExamTerm(Long id) {
        this.id = id;
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

    public ExamPeriod getExamPeriod() {
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriod examPeriod) {
        this.examPeriod = examPeriod;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

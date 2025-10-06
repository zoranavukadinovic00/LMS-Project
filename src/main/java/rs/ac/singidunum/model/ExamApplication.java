package rs.ac.singidunum.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rs.ac.singidunum.model.enums.ExamApplicationStatus;



@Entity
public class ExamApplication {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private User student;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;
	
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExamApplicationStatus status;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_term_id", nullable = false)
    private ExamTerm examTerm;
	
    @CreationTimestamp
    @Column(name = "application_date", nullable = true)
    private LocalDateTime applicationDate;
	
    @Column(name = "points", nullable = false)
    private int points;

    public ExamApplication() {
        super();
    }
	
    public ExamApplication(Long id, User student, Course course, ExamApplicationStatus status, ExamTerm examTerm,
            LocalDateTime applicationDate, int points) {
        super();
        this.id = id;
        this.student = student;
        this.course = course;
        this.status = status;
        this.examTerm = examTerm;
        this.applicationDate = applicationDate;
        this.points = points;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public ExamTerm getExamTerm() {
        return examTerm;
    }

    public void setExamTerm(ExamTerm examTerm) {
        this.examTerm = examTerm;
    }
	
}

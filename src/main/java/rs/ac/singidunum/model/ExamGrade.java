package rs.ac.singidunum.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExamGrade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_term_id")
    private ExamTerm examTerm;

    @Column(nullable = false)
    private int grade;

    @Column(name = "date_graded")
    private LocalDate dateGraded;

    public ExamGrade() {
        super();
    }

    public ExamGrade(Long id, User student, Course course, ExamTerm examTerm, Integer grade, LocalDate dateGraded) {
        super();
        this.id = id;
        this.student = student;
        this.course = course;
        this.examTerm = examTerm;
        this.grade = grade;
        this.dateGraded = dateGraded;
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

    public ExamTerm getExamTerm() {
        return examTerm;
    }

    public void setExamTerm(ExamTerm examTerm) {
        this.examTerm = examTerm;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDate getDateGraded() {
        return dateGraded;
    }

    public void setDateGraded(LocalDate dateGraded) {
        this.dateGraded = dateGraded;
    }
}

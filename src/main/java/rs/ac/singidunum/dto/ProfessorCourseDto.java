package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.ProfessorCourse;
import rs.ac.singidunum.model.User;

public class ProfessorCourseDto {

	private Long id;
    private Long professorId;
    private String professorFullName;
    private Long courseId;
    private String courseName;
    
    public ProfessorCourseDto(ProfessorCourse professorCourse) {
        id = professorCourse.getId();

        User professor = professorCourse.getProfessor();
        professorId = professor.getId();
        professorFullName = professor.getName() + " " + professor.getSurname();

        Course course = professorCourse.getCourse();
        courseId = course.getId();
        courseName = course.getName();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public String getProfessorFullName() {
		return professorFullName;
	}

	public void setProfessorFullName(String professorFullName) {
		this.professorFullName = professorFullName;
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

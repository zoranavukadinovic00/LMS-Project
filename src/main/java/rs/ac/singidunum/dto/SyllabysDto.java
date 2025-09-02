package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Syllabus;

public class SyllabysDto {

	private Long id;
	private String description;
	private long courseId;
	
	public SyllabysDto() {
		super();
	}
	
	public SyllabysDto(Syllabus syllabus) {
		this.id = syllabus.getId();
		this.description = syllabus.getDescription();
		this.courseId = syllabus.getCourse().getId();
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
}


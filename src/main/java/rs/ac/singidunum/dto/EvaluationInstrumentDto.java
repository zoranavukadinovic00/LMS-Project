package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.EvaluationInstrument;

public class EvaluationInstrumentDto {
	private long id;
	
	private int points;
	
	private String name;
	
	private long courseId;
	private String courseName;
	public EvaluationInstrumentDto() {
		super();
	}
	public EvaluationInstrumentDto(EvaluationInstrument evaluationInstrument) {
		this.id = evaluationInstrument.getId();
		this.points = evaluationInstrument.getPoints();
		this.name = evaluationInstrument.getName();
		this.courseId = evaluationInstrument.getCourse().getId();
		this.courseName = evaluationInstrument.getCourse().getName();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}

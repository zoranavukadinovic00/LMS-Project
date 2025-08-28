package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Course;

public class CourseDto {
	private long id;
	private String name;
	private int espbPoints;
	
	
	public CourseDto(Course course) {
		this.id = course.getId();
		name = course.getName();
		espbPoints = course.getEspbPoints();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEspbPoints() {
		return espbPoints;
	}


	public void setEspbPoints(int espbPoints) {
		this.espbPoints = espbPoints;
	}
	
	
}

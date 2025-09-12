package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Course;

public class CourseDetailsDto {
	
    private Long id;
	private String name;
	private int espbPoints;
	public boolean mandatory;
	private int numberOfLectures;
	private int numberOfExercises;
	private int otherFormsOfTeaching;
	private int researchWork;
	private int otherClasses;
	private String teachingMaterials;
	
	public CourseDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDetailsDto(Long id, String name, int espbPoints, boolean mandatory, int numberOfLectures,
			int numberOfExercises, int otherFormsOfTeaching, int researchWork, int otherClasses,
			String teachingMaterials) {
		super();
		this.id = id;
		this.name = name;
		this.espbPoints = espbPoints;
		this.mandatory = mandatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExercises = numberOfExercises;
		this.otherFormsOfTeaching = otherFormsOfTeaching;
		this.researchWork = researchWork;
		this.otherClasses = otherClasses;
		this.teachingMaterials = teachingMaterials;
	}
	
	public CourseDetailsDto(Course course) {
	    this.id = course.getId();
	    this.name = course.getName();
	    this.espbPoints = course.getEspbPoints();
	    this.mandatory = course.isMandatory();
	    this.numberOfLectures = course.getNumberOfLectures();
	    this.numberOfExercises = course.getNumberOfExercises();
	    this.otherFormsOfTeaching = course.getOtherFormsOfTeaching();
	    this.researchWork = course.getResearchWork();
	    this.otherClasses = course.getOtherClasses();
	    this.teachingMaterials = course.getTeachingMaterials();
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

	public int getEspbPoints() {
		return espbPoints;
	}

	public void setEspbPoints(int espbPoints) {
		this.espbPoints = espbPoints;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExercises() {
		return numberOfExercises;
	}

	public void setNumberOfExercises(int numberOfExercises) {
		this.numberOfExercises = numberOfExercises;
	}

	public int getOtherFormsOfTeaching() {
		return otherFormsOfTeaching;
	}

	public void setOtherFormsOfTeaching(int otherFormsOfTeaching) {
		this.otherFormsOfTeaching = otherFormsOfTeaching;
	}

	public int getResearchWork() {
		return researchWork;
	}

	public void setResearchWork(int researchWork) {
		this.researchWork = researchWork;
	}

	public int getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(int otherClasses) {
		this.otherClasses = otherClasses;
	}

	public String getTeachingMaterials() {
		return teachingMaterials;
	}

	public void setTeachingMaterials(String teachingMaterials) {
		this.teachingMaterials = teachingMaterials;
	}
	
	
	

}

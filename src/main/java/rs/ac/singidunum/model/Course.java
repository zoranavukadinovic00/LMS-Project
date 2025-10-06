package rs.ac.singidunum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "espb_points", nullable = false)
	private int espbPoints;

	@Column(name = "mandatory", nullable = false)
	private boolean mandatory;
	
	@Column(name = "number_of_lectures", nullable = false)
	private int numberOfLectures;
	
	@Column(name = "number_of_exercises", nullable = false)
	private int numberOfExercises;
	
	@Column(name = "other_forms_of_teaching", nullable = false)
	private int otherFormsOfTeaching;
	
	@Column(name = "research_work", nullable = false)
	private int researchWork;
	
	@Column(name = "other_classes", nullable = false)
	private int otherClasses;
	
	@Column(name = "teaching_materials", nullable = false)
	private String teachingMaterials;

	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(Long id, String name, int espbPoints, boolean mandatory, int numberOfLectures, int numberOfExercises,
			int otherFormsOfTeaching, int researchWork, int otherClasses, String teachingMaterials) {
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
	
	public Course(Long id) {
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

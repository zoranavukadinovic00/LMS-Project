package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.Course;

public class CourseDto {
	private long id;
	private String name;
	private int espbPoints;
	
	private Long studyProgramId;
    private String studyProgramName;
	
	public CourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CourseDto(long id, String name, int espbPoints, Long studyProgramId, String studyProgramName) {
		super();
		this.id = id;
		this.name = name;
		this.espbPoints = espbPoints;
		this.studyProgramId = studyProgramId;
		this.studyProgramName = studyProgramName;
	}

	public CourseDto(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.espbPoints = course.getEspbPoints();
		
		
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

	public Long getStudyProgramId() {
		return studyProgramId;
	}

	public void setStudyProgramId(Long studyProgramId) {
		this.studyProgramId = studyProgramId;
	}

	public String getStudyProgramName() {
		return studyProgramName;
	}

	public void setStudyProgramName(String studyProgramName) {
		this.studyProgramName = studyProgramName;
	}
	
	
	
	
}

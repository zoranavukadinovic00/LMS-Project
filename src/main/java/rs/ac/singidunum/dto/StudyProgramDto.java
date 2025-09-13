package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.StudyProgram;

public class StudyProgramDto {
	
	
	 private Long id;
	 private String name;
	 private Long facultyId;
	 private String facultyName;
	 private String description;
	 private Long managerId;
	 private String managerName;
	 private String managerSurname;   
	 private String managerEmail;
	 
	 
	 
	 
	 public StudyProgramDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudyProgramDto(Long id, String name, Long facultyId, String facultyName, String description, Long managerId,
			String managerName, String managerSurname, String managerEmail) {
		super();
		this.id = id;
		this.name = name;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.description = description;
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerSurname = managerSurname;
		this.managerEmail = managerEmail;
	}

	public StudyProgramDto(StudyProgram studyProgram) {
		 
	     this.id = studyProgram.getId();
		 this.name = studyProgram.getName();
		 this.facultyId = studyProgram.getFaculty().getId();
		 this.facultyName = studyProgram.getFaculty().getName();
		 this.description = studyProgram.getDescription();
		 this.managerId = studyProgram.getManager().getId();
		 this.managerName = studyProgram.getManager().getName();
		 this.managerSurname = studyProgram.getManager().getSurname();
		 this.managerEmail = studyProgram.getManager().getEmail();
		 
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

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerSurname() {
		return managerSurname;
	}

	public void setManagerSurname(String managerSurname) {
		this.managerSurname = managerSurname;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	
	
		
}

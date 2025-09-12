package rs.ac.singidunum.dto;

import rs.ac.singidunum.model.TermTopic;

public class TermTopicDto {

    private  Long id;
	private String description;
	private  int termNumber;
	private long courseId;
	public TermTopicDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TermTopicDto(Long id, String description, int termNumber, long courseId) {
		super();
		this.id = id;
		this.description = description;
		this.termNumber = termNumber;
		this.courseId = courseId;
	}
	
	public TermTopicDto(TermTopic termTopic) {
        this.id = termTopic.getId();
        this.description = termTopic.getDescription();
        this.termNumber = termTopic.getTermNumber();
        
        this.courseId = termTopic.getCourse().getId();
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
	
	public int getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	
}

package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.CourseNotification;


public class CourseNotificationDto {
	private Long id;
	
	private Long courseId;
	
	private String title;
	
	private String content;
	
	private LocalDateTime postedAt;

	private String courseName;
	
	
	public CourseNotificationDto() {
		super();
	}

	public CourseNotificationDto(CourseNotification courseNotification) {
		id = courseNotification.getId();
		courseId = courseNotification.getCourse().getId();
		title = courseNotification.getTitle();
		content = courseNotification.getContent();
		postedAt = courseNotification.getPostedAt();
		courseName = courseNotification.getCourse().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}

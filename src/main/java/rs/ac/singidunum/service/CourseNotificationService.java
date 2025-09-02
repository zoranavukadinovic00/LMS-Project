package rs.ac.singidunum.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.CourseNotificationDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.CourseNotification;
import rs.ac.singidunum.repository.CourseNotificationRepository;
import rs.ac.singidunum.repository.CourseRepository;
@Service
public class CourseNotificationService {
	
	@Autowired
    private CourseNotificationRepository courseNotificationRepository;
	@Autowired
	private  CourseRepository courseRepository;

    public List<CourseNotification> findAll() {
        return courseNotificationRepository.findAll();
    }

    public CourseNotification findOne(Long id) {
        return courseNotificationRepository.findById(id).orElse(null);
    }

    public CourseNotification save(CourseNotificationDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        CourseNotification notification = new CourseNotification();
        notification.setTitle(dto.getTitle());
        notification.setContent(dto.getContent());
        notification.setCourse(course);
        notification.setPostedAt(LocalDateTime.now());

        return courseNotificationRepository.save(notification);
    }

    public CourseNotification update(CourseNotificationDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        CourseNotification notification = courseNotificationRepository.findById(dto.getId()).orElse(null);
        if (notification == null) {
            return null;
        }

        notification.setTitle(dto.getTitle());
        notification.setContent(dto.getContent());
        notification.setCourse(course);
        notification.setPostedAt(LocalDateTime.now());


        return courseNotificationRepository.save(notification);
    }


    public void delete(Long id) {
    	courseNotificationRepository.deleteById(id);
    }

    public void delete(CourseNotification notification) {
    	courseNotificationRepository.delete(notification);
    }
    
    public List<CourseNotification> getCourseNotificationsForStudent(Long studentId){
    	return courseNotificationRepository.findAllNotificationsByStudentId(studentId);
    }

    public List<CourseNotification> getNotificationsByProfessorId(Long professorId) {
        return courseNotificationRepository.findAllNotificationByProfessorId(professorId);
    }
    public List<CourseNotification> getNotificationsByCourseId(Long courseId) {
        return courseNotificationRepository.findByCourse(courseId);
    }
}

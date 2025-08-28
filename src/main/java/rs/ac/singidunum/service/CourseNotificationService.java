package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.CourseNotification;
import rs.ac.singidunum.repository.CourseNotificationRepository;
@Service
public class CourseNotificationService {
	
	@Autowired
    private CourseNotificationRepository courseNotificationRepository;

    public List<CourseNotification> findAll() {
        return courseNotificationRepository.findAll();
    }

    public CourseNotification findOne(Long id) {
        return courseNotificationRepository.findById(id).orElse(null);
    }

    public CourseNotification save(CourseNotification notification) {
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
        return courseNotificationRepository.findAllByProfessorId(professorId);
    }
}

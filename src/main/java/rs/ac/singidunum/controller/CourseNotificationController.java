package rs.ac.singidunum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.CourseNotificationDto;
import rs.ac.singidunum.model.CourseNotification;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.CourseNotificationService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/course_notifications")
public class CourseNotificationController {
	
	@Autowired
    private CourseNotificationService courseNotificationService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/studentNotifications")
    public ResponseEntity<List<CourseNotificationDto>> getNotificationsByStudent(@AuthenticationPrincipal UserDetails user) {
		
		String username = user.getUsername();
		User foundUser = userService.findByUsername(username);
		long studentId = foundUser.getId();
		
        List<CourseNotification> courseNotifications = courseNotificationService.getCourseNotificationsForStudent(studentId);

        List<CourseNotificationDto> dtos = new ArrayList<CourseNotificationDto>();
        
        for(CourseNotification courseNotification : courseNotifications){
            dtos.add(new CourseNotificationDto(courseNotification));
        }
        
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
	
	@GetMapping("/professorNotifications/{professorId}")
    public ResponseEntity<List<CourseNotificationDto>> getNotificationsByProfessor(@PathVariable Long professorId) {
        List<CourseNotification> courseNotifications = courseNotificationService.getNotificationsByProfessorId(professorId);

        List<CourseNotificationDto> dtos = new ArrayList<>();
        for (CourseNotification courseNotification : courseNotifications) {
            dtos.add(new CourseNotificationDto(courseNotification));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}

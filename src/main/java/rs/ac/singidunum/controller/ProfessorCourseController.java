package rs.ac.singidunum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.ProfessorCourseDto;
import rs.ac.singidunum.model.ProfessorCourse;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.ProfessorCourseService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/professor_courses")
public class ProfessorCourseController {
	
	@Autowired
    private ProfessorCourseService professorCourseService;
	@Autowired
	private UserService userService;

	@GetMapping("/professor_assigned_courses")
	public ResponseEntity<List<ProfessorCourseDto>> getProfessorAssignedCourses(@AuthenticationPrincipal UserDetails user) {
		
		String username = user.getUsername();
		User foundUser = userService.findByUsername(username);
		long userId = foundUser.getId();
		
	    List<ProfessorCourse> professorCourses = professorCourseService.getCoursesByProfessorId(userId);

	    List<ProfessorCourseDto> dtos = new ArrayList<>();
	    for (ProfessorCourse professorcourse : professorCourses) {
	        dtos.add(new ProfessorCourseDto(professorcourse));
	    }

	    return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	

}

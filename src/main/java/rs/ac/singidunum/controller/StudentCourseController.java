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

import rs.ac.singidunum.dto.StudentCourseDto;
import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.StudentCourseService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/student_courses")
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;

	@Autowired
	private UserService userService;

	@GetMapping("/studentEnrolledCourses")
	public ResponseEntity<List<StudentCourseDto>> getStudentEnrollCourses(@AuthenticationPrincipal UserDetails user) {

		String username = user.getUsername();
		User foundUser = userService.findByUsername(username);
		long userId = foundUser.getId();

		List<StudentCourse> studentCourses = studentCourseService.getStudentsEnrolledCourses(userId);

		List<StudentCourseDto> dtos = new ArrayList<StudentCourseDto>();

		for (StudentCourse studentCourse : studentCourses) {
			dtos.add(new StudentCourseDto(studentCourse));
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping("/studentPassedCourses")
	public ResponseEntity<List<StudentCourseDto>> getStudentPassedCourses(@AuthenticationPrincipal UserDetails user) {
		
		String username = user.getUsername();
		User foundUser = userService.findByUsername(username);
		long userId = foundUser.getId();

		List<StudentCourse> studentCourses = studentCourseService.getStudentsPassedCourses(userId);

		List<StudentCourseDto> dtos = new ArrayList<StudentCourseDto>();

		for (StudentCourse studentCourse : studentCourses) {
			dtos.add(new StudentCourseDto(studentCourse));
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}

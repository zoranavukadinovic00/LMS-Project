package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.CourseOnProgramService;

@RestController
@RequestMapping("/api/course_on_programs")
public class CourseOnProgramController {
	
	@Autowired
    private CourseOnProgramService courseOnProgramService;
	
	


}

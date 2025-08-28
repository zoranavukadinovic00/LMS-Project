package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
    private CourseService courseService;
}

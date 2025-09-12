package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.CourseDetailsDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
    private CourseService courseService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDetailsDto> getCourse(@PathVariable("id") Long id) {
	    Course course = courseService.findOne(id);

	    if (course == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    CourseDetailsDto dto = new CourseDetailsDto(course);

	    return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}

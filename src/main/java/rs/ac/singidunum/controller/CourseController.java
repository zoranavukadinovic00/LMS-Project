package rs.ac.singidunum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.CourseDetailsDto;
import rs.ac.singidunum.dto.CourseDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // NOVI ENDPOINT: Dohvaća sve predmete
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<Course> courses = courseService.findAll(); 

        List<CourseDto> dtos = new ArrayList<>();

        for (Course c : courses) {
            dtos.add(new CourseDto(c));
        }
        
        return ResponseEntity.ok(dtos);
    }
    // KRAJ NOVOG ENDPOINTA

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailsDto> getCourse(@PathVariable("id") Long id) {
        Course course = courseService.findOne(id);

        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CourseDetailsDto dto = new CourseDetailsDto(course);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/forStudyProgram/{programId}")

    public ResponseEntity<List<CourseDto>> listCourses(@PathVariable Long programId) {

        List<Course> courses = courseService.getAllByProgramId(programId);

        List<CourseDto> dtos = new ArrayList<>();

        for (Course c : courses)
            dtos.add(new CourseDto(c));

        return ResponseEntity.ok(dtos);

    }

}

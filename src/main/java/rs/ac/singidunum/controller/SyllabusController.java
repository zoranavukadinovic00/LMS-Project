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

import rs.ac.singidunum.dto.SyllabysDto;
import rs.ac.singidunum.model.Syllabus;
import rs.ac.singidunum.service.SyllabusService;

@RestController
@RequestMapping("/api/syllabuses")
public class SyllabusController {

	@Autowired
    private SyllabusService syllabusService;
	

	@GetMapping("/by_course/{courseId}")
	public ResponseEntity<List<SyllabysDto>> getStudentPassedCourses(@PathVariable("courseId")long courseId) {
		
		List<Syllabus> syllabus = syllabusService.getAllByCourseId(courseId);

		List<SyllabysDto> dtos = new ArrayList<SyllabysDto>();

		for (Syllabus syllabuses : syllabus) {
			dtos.add(new SyllabysDto(syllabuses));
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}

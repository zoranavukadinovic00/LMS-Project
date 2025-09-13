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

import rs.ac.singidunum.dto.CourseDto;
import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.service.CourseOnProgramService;
import rs.ac.singidunum.service.StudyProgramService;

@RestController
@RequestMapping("/api/study_programs")
public class StudyProgramController {

	@Autowired
    private StudyProgramService studyProgramService;
	private CourseOnProgramService courseOnProgramService;
	
	@GetMapping("/by_faculty/{facultyId}")
    public ResponseEntity<List<StudyProgramDto>> getByFaculty(@PathVariable("facultyId") Long facultyId) {

        List<StudyProgram> programs = studyProgramService.getAllByFacultyId(facultyId);

        List<StudyProgramDto> dtos = new ArrayList<>();
        for (StudyProgram sp : programs) {
            dtos.add(new StudyProgramDto(
                sp.getId(),
                sp.getName(),
                sp.getFaculty().getId(),
                sp.getFaculty().getName(),
                sp.getDescription(),
                sp.getManager().getId(),
                sp.getManager().getName(),
                sp.getManager().getSurname(),
                sp.getManager().getEmail()
            ));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
	@GetMapping("/{programId}/courses")
    public ResponseEntity<List<CourseDto>> getCourses(@PathVariable Long programId) {
        List<Course> courses = courseOnProgramService.getCoursesByProgram(programId);
        List<CourseDto> dtos = courses.stream().map(CourseDto::new).toList();
        return ResponseEntity.ok(dtos);
    }
}

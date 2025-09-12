package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.StudentDetailsDto;
import rs.ac.singidunum.model.StudentOnYear;
import rs.ac.singidunum.service.StudentOnYearService;

@RestController
@RequestMapping("/api/students")
public class StudentOnYearController {

	@Autowired
    private StudentOnYearService studentOnYearService;
	
	@GetMapping("/search")
    public ResponseEntity<Page<StudentOnYear>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String index,
            @RequestParam(required = false) Integer enrollmentYear,
            @RequestParam(required = false) Integer studyYear,
            @RequestParam(required = false) Double minAverageGrade,
            @RequestParam(required = false) Double maxAverageGrade,
            @PageableDefault(size = 10, sort = "student.surname", direction = Sort.Direction.ASC) Pageable pageable
            

    ) {
        Page<StudentOnYear> result = studentOnYearService.searchStudents(name, surname, index, enrollmentYear, studyYear, minAverageGrade, maxAverageGrade, pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDetailsDto> getStudDetails(@PathVariable("id") Long id) {
		StudentDetailsDto studentDetailsDto = studentOnYearService.getStudentDetails(id);

	  
	    return new ResponseEntity<>(studentDetailsDto, HttpStatus.OK);
	}
}

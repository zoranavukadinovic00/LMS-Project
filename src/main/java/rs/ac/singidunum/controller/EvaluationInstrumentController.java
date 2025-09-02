package rs.ac.singidunum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rs.ac.singidunum.dto.EvaluationInstrumentDto;
import rs.ac.singidunum.model.EvaluationInstrument;
import rs.ac.singidunum.service.EvaluationInstrumentService;

@RestController
@RequestMapping("/api/evaluation-instruments")
public class EvaluationInstrumentController {

	@Autowired
    private EvaluationInstrumentService evaluationInstrumentService;
	
	
	@GetMapping("/by_course/{courseId}")
	public ResponseEntity<List<EvaluationInstrumentDto>> getStudentPassedCourses(@PathVariable("courseId")long courseId) {
		
		List<EvaluationInstrument> evaluationInstruments = evaluationInstrumentService.getAllByCourseId(courseId);

		List<EvaluationInstrumentDto> dtos = new ArrayList<EvaluationInstrumentDto>();

		for (EvaluationInstrument evaluationInstrument : evaluationInstruments) {
			dtos.add(new EvaluationInstrumentDto(evaluationInstrument));
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody EvaluationInstrumentDto dto) {
	    EvaluationInstrument evaluationInstrument = evaluationInstrumentService.save(dto);
	    if (evaluationInstrument == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    EvaluationInstrumentDto returnDto = new EvaluationInstrumentDto(evaluationInstrument);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody EvaluationInstrumentDto dto) {
	    dto.setId(id);

	    EvaluationInstrument evaluationInstrument = evaluationInstrumentService.update(dto);
	    if (evaluationInstrument == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    EvaluationInstrumentDto returnDto = new EvaluationInstrumentDto(evaluationInstrument);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    evaluationInstrumentService.delete(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

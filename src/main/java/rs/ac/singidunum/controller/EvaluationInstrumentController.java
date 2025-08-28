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

import rs.ac.singidunum.dto.EvaluationInstrumentDto;
import rs.ac.singidunum.model.EvaluationInstrument;
import rs.ac.singidunum.service.EvaluationInstrumentService;

@RestController
@RequestMapping("/api/evaluation_instruments")
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
	
	
}

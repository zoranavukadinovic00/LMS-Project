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
import rs.ac.singidunum.dto.ExamPeriodDto;
import rs.ac.singidunum.model.ExamPeriod;
import rs.ac.singidunum.service.ExamPeriodService;

@RestController
@RequestMapping("/api/exam_periods")
public class ExamPeriodController {
	
	@Autowired
    private ExamPeriodService examPeriodService;
	
	@GetMapping
	public ResponseEntity<List<ExamPeriodDto>> getAll() {
	    List<ExamPeriod> examPeriods = examPeriodService.findAll();
	    List<ExamPeriodDto> dtos = new ArrayList<>();
	    for (ExamPeriod ep : examPeriods) {
	        dtos.add(new ExamPeriodDto(ep));
	    }
	    return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody ExamPeriodDto dto) {
	    ExamPeriod examPeriod = examPeriodService.save(dto);
	    if (examPeriod == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    ExamPeriodDto returnDto = new ExamPeriodDto(examPeriod);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ExamPeriodDto dto) {
	    dto.setId(id);
	    ExamPeriod examPeriod = examPeriodService.update(dto);
	    if (examPeriod == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    ExamPeriodDto returnDto = new ExamPeriodDto(examPeriod);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    examPeriodService.delete(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}


}

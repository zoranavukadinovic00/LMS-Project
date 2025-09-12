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
import rs.ac.singidunum.dto.TermTopicDto;
import rs.ac.singidunum.model.TermTopic;
import rs.ac.singidunum.service.TermTopicService;

@RestController
@RequestMapping("/api/term-topics")
public class TermTopicController {
	
	@Autowired
    private TermTopicService termTopicService;
	
	@GetMapping("/by_course/{courseId}")
	public ResponseEntity<List<TermTopicDto>> getByCourse(@PathVariable("courseId") long courseId) {
	    List<TermTopic> entities = termTopicService.getAllByCourseId(courseId);

	    List<TermTopicDto> dtos = new ArrayList<>();
	    for (TermTopic t : entities) {
	        dtos.add(new TermTopicDto(t));
	    }
	    return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody TermTopicDto dto) {
	    TermTopic termTopic = termTopicService.save(dto);
	    if (termTopic == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    TermTopicDto returnDto = new TermTopicDto(termTopic);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody TermTopicDto dto) {
	    TermTopic termTopic = termTopicService.update(dto);
	    if (termTopic == null) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	    TermTopicDto returnDto = new TermTopicDto(termTopic);
	    return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    termTopicService.delete(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}


	
}

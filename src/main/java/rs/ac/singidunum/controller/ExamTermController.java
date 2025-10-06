package rs.ac.singidunum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.ExamTermDto;
import rs.ac.singidunum.model.ExamTerm;
import rs.ac.singidunum.service.CourseService;
import rs.ac.singidunum.service.ExamPeriodService;
import rs.ac.singidunum.service.ExamTermService;

@RestController
@RequestMapping("/api/exam_terms")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamTermController {
	
	@Autowired
    private ExamTermService examTermService;

    @Autowired
    private ExamPeriodService examPeriodService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<ExamTermDto> getAll() {
        return examTermService.getAllTerms()
                .stream()
                .map(ExamTermDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            ExamTerm term = examTermService.getTermById(id)
                    .orElseThrow(() -> new RuntimeException("Exam term not found"));
            return ResponseEntity.ok(new ExamTermDto(term));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/period/{periodId}")
    public List<ExamTermDto> getByPeriod(@PathVariable Long periodId) {
        return examTermService.getTermsByExamPeriod(periodId)
                .stream()
                .map(ExamTermDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ExamTermDto dto) {
        try {
            ExamTerm term = new ExamTerm();
            term.setName(dto.getName());
            term.setExamDate(dto.getExamDate());
            term.setExamPeriod(examPeriodService.getPeriodById(dto.getPeriodId())
                    .orElseThrow(() -> new RuntimeException("Exam period not found")));
            term.setCourse(courseService.getCourseById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found")));
            return ResponseEntity.ok(new ExamTermDto(examTermService.saveTerm(term)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            examTermService.deleteTerm(id);
            return ResponseEntity.ok("Exam term deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

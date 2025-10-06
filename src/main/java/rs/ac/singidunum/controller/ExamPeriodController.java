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

import rs.ac.singidunum.dto.ExamPeriodDto;
import rs.ac.singidunum.model.ExamPeriod;
import rs.ac.singidunum.service.ExamPeriodService;

@RestController
@RequestMapping("/api/exam_periods")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamPeriodController {

	@Autowired
    private ExamPeriodService examPeriodService;

    @GetMapping
    public List<ExamPeriodDto> getAllPeriods() {
        return examPeriodService.getAllPeriods()
                .stream()
                .map(ExamPeriodDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeriodById(@PathVariable Long id) {
        try {
            ExamPeriod period = examPeriodService.getPeriodById(id)
                    .orElseThrow(() -> new RuntimeException("Exam period not found"));
            return ResponseEntity.ok(new ExamPeriodDto(period));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createPeriod(@RequestBody ExamPeriodDto periodDto) {
        try {
            ExamPeriod period = new ExamPeriod();
            period.setName(periodDto.getName());
            period.setStartDate(periodDto.getStartDate());
            period.setEndDate(periodDto.getEndDate());
            ExamPeriod saved = examPeriodService.savePeriod(period);
            return ResponseEntity.ok(new ExamPeriodDto(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeriod(@PathVariable Long id) {
        try {
            examPeriodService.deletePeriod(id);
            return ResponseEntity.ok("Exam period deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

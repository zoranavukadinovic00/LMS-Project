package rs.ac.singidunum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.ExamApplicationDto;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.ExamApplicationService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/exam_applications")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamApplicationController {
	
	@Autowired
    private ExamApplicationService examApplicationService;
	@Autowired
	private UserService userService;


    @GetMapping
    public List<ExamApplicationDto> getAllApplications() {
        return examApplicationService.getAllApplications()
                .stream()
                .map(ExamApplicationDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/course/{courseId}")
    public List<ExamApplicationDto> getStudentsForCourse(@PathVariable Long courseId) {
        return examApplicationService.getStudentsForCourse(courseId)
                .stream()
                .map(ExamApplicationDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/term/{termId}")
    public List<ExamApplicationDto> getApplicationsByTerm(@PathVariable Long termId) {
        return examApplicationService.getApplicationsByTerm(termId)
                .stream()
                .map(ExamApplicationDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyForExam(
            @RequestParam Long termId,
            Authentication authentication) {  
        try {
            String username = authentication.getName();
            User student = userService.getUserByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            
            return ResponseEntity.ok(new ExamApplicationDto(
                examApplicationService.applyForExam(student.getId(), termId)
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable Long id) {
        try {
            examApplicationService.deleteApplication(id);
            return ResponseEntity.ok("Application deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

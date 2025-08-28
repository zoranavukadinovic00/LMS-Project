package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.StudentEvaluationService;

@RestController
@RequestMapping("/api/student_evaluations")
public class StudentEvaluationController {

	@Autowired
    private StudentEvaluationService studentEvaluationService;
}

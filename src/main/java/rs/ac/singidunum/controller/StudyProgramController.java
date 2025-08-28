package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.StudyProgramService;

@RestController
@RequestMapping("/api/study_programs")
public class StudyProgramController {

	@Autowired
    private StudyProgramService studyProgramService;
}

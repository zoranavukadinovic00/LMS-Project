package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

	@Autowired
    private UniversityService universityService;
}

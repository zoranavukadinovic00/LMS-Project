package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
    private FacultyService facultyService;
}

package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
    private CountryService countryService;
}

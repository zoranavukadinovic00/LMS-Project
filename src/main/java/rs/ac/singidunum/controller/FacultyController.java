package rs.ac.singidunum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.FacultyDto;
import rs.ac.singidunum.model.Faculty;
import rs.ac.singidunum.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public ResponseEntity<List<FacultyDto>> getAllFaculties() {
        try {
            List<Faculty> faculties = facultyService.findAll();
            List<FacultyDto> facultyDtos = faculties.stream()
                .map(FacultyDto::new)
                .toList();
            return ResponseEntity.ok(facultyDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            
            Faculty faculty = facultyService.findOne(id);
            if (faculty == null) {
                return ResponseEntity.notFound().build();
            }
            
            FacultyDto dto = new FacultyDto(faculty);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
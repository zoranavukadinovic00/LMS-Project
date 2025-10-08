package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.model.Faculty;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.StudyProgramService;
import rs.ac.singidunum.service.FacultyService;
import rs.ac.singidunum.service.UserService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/study-programs")
@PreAuthorize("hasRole('ADMIN')")
public class StudyProgramAdminController {

    private final StudyProgramService studyProgramService; 
    private final FacultyService facultyService; 
    private final UserService userService; 

   @Autowired
    public StudyProgramAdminController(StudyProgramService studyProgramService, FacultyService facultyService, UserService userService) {
        this.studyProgramService = studyProgramService;
        this.facultyService = facultyService; 
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<StudyProgramDto>> getAllStudyPrograms() {
        List<StudyProgram> studyPrograms = studyProgramService.findAll();
        List<StudyProgramDto> dtos = studyPrograms.stream()
                .map(StudyProgramDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudyProgramDto> getStudyProgram(@PathVariable Long id) {
        StudyProgram studyProgram = studyProgramService.findOne(id);
        if (studyProgram == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new StudyProgramDto(studyProgram), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudyProgramDto> createStudyProgram(@RequestBody StudyProgramDto dto) {
        
        System.out.println("LOG: Attempting to create Study Program. Received DTO:");
        System.out.println("LOG: Name: " + dto.getName());
        System.out.println("LOG: Faculty ID: " + dto.getFacultyId());
        System.out.println("LOG: Manager ID: " + dto.getManagerId());


        // Provera da li su ID-evi validni (ne null i veći od 0)
        if (dto.getFacultyId() == null || dto.getFacultyId() <= 0 || dto.getManagerId() == null || dto.getManagerId() <= 0) {
            System.err.println("ERROR: Missing or invalid Faculty ID (" + dto.getFacultyId() + ") or Manager ID (" + dto.getManagerId() + "). Returning BAD_REQUEST (400).");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Faculty faculty = facultyService.findOne(dto.getFacultyId());
        User manager = userService.findOne(dto.getManagerId());
        
        System.out.println("LOG: Faculty found: " + (faculty != null));
        System.out.println("LOG: Manager found: " + (manager != null));


        if (faculty == null || manager == null) {
            // Provera da li entiteti zaista postoje u bazi
            String missingEntity = faculty == null ? "Faculty" : (manager == null ? "Manager" : "None");
            System.err.println("ERROR: Dependent entity not found. Missing: " + missingEntity + ". Returning BAD_REQUEST (400).");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName(dto.getName());
        studyProgram.setDescription(dto.getDescription());
        studyProgram.setFaculty(faculty);
        studyProgram.setManager(manager);

        StudyProgram savedProgram = studyProgramService.save(studyProgram);
        
        // 🚨 PROVERA: Da li je entitet dobio ID nakon snimanja (provera da li je snimanje uspelo)
        if (savedProgram == null || savedProgram.getId() == null) {
            System.err.println("ERROR: Database save failed: StudyProgram entity did not receive an ID. Returning INTERNAL_SERVER_ERROR (500).");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        System.out.println("LOG: Study Program successfully created with ID: " + savedProgram.getId());
        return new ResponseEntity<>(new StudyProgramDto(savedProgram), HttpStatus.CREATED);
    }

    // PUT metoda je ostala nepromenjena i radi ispravno (delegira Servisu)
    @PutMapping("/{id}")
    public ResponseEntity<StudyProgramDto> updateStudyProgram(@PathVariable Long id, @RequestBody StudyProgramDto dto) {
        
        StudyProgramDto updatedProgram = studyProgramService.update(id, dto);
        
        return new ResponseEntity<>(updatedProgram, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudyProgram(@PathVariable Long id) {
        StudyProgram studyProgram = studyProgramService.findOne(id);
        if (studyProgram == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studyProgramService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

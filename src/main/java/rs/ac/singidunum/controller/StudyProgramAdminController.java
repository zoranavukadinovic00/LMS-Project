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
        
        if (dto.getFacultyId() == null || dto.getFacultyId() <= 0 || dto.getManagerId() == null || dto.getManagerId() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Faculty faculty = facultyService.findOne(dto.getFacultyId());
        User manager = userService.findOne(dto.getManagerId());

        if (faculty == null || manager == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName(dto.getName());
        studyProgram.setDescription(dto.getDescription());
        studyProgram.setFaculty(faculty);
        studyProgram.setManager(manager);

        StudyProgram savedProgram = studyProgramService.save(studyProgram);
        return new ResponseEntity<>(new StudyProgramDto(savedProgram), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyProgramDto> updateStudyProgram(@PathVariable Long id, @RequestBody StudyProgramDto dto) {
        StudyProgram existingProgram = studyProgramService.findOne(id);
        if (existingProgram == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingProgram.setName(dto.getName());
        existingProgram.setDescription(dto.getDescription());

        if (dto.getFacultyId() != null && dto.getFacultyId() > 0) {
            Faculty faculty = facultyService.findOne(dto.getFacultyId());
            if (faculty != null) {
                existingProgram.setFaculty(faculty);
            }
        }
        if (dto.getManagerId() != null && dto.getManagerId() > 0) {
            User manager = userService.findOne(dto.getManagerId());
            if (manager != null) {
                existingProgram.setManager(manager);
            }
        }

        StudyProgram updatedProgram = studyProgramService.save(existingProgram);
        return new ResponseEntity<>(new StudyProgramDto(updatedProgram), HttpStatus.OK);
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
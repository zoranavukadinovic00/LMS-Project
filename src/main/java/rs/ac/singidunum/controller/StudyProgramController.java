// rs/ac/singidunum/controller/StudyProgramController.java

package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.service.StudyProgramService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/study-programs")
public class StudyProgramController {

    private final StudyProgramService studyProgramService;

    @Autowired
    public StudyProgramController(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyProgramDto> getById(@PathVariable Long id) {
        StudyProgram studyProgram = studyProgramService.findOne(id);
        if (studyProgram == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new StudyProgramDto(studyProgram));
    }

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<StudyProgramDto>> getByFacultyId(@PathVariable Long facultyId) {
        List<StudyProgram> studyPrograms = studyProgramService.getAllByFacultyId(facultyId);
        List<StudyProgramDto> dtos = studyPrograms.stream()
                .map(StudyProgramDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
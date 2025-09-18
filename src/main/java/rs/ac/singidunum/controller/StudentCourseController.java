// src/main/java/rs/ac/singidunum/controller/StudentController.java

package rs.ac.singidunum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.StudentCourseDto;
import rs.ac.singidunum.dto.DocumentRequestDto;
import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.StudentCourseService;
import rs.ac.singidunum.service.UserService;
import rs.ac.singidunum.service.DocumentService;

@RestController
@RequestMapping("/api/student") // Promenjen je naziv rute
public class StudentCourseController { // Preimenovan je naziv klase

    @Autowired
    private StudentCourseService studentCourseService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private DocumentService documentService;

    @GetMapping("/studentEnrolledCourses")
    public ResponseEntity<List<StudentCourseDto>> getStudentEnrollCourses(@AuthenticationPrincipal UserDetails user) {

        String username = user.getUsername();
        User foundUser = userService.findByUsername(username);
        long userId = foundUser.getId();

        List<StudentCourse> studentCourses = studentCourseService.getStudentsEnrolledCourses(userId);

        List<StudentCourseDto> dtos = new ArrayList<StudentCourseDto>();

        for (StudentCourse studentCourse : studentCourses) {
            dtos.add(new StudentCourseDto(studentCourse));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/studentPassedCourses")
    public ResponseEntity<List<StudentCourseDto>> getStudentPassedCourses(@AuthenticationPrincipal UserDetails user) {
        
        String username = user.getUsername();
        User foundUser = userService.findByUsername(username);
        long userId = foundUser.getId();

        List<StudentCourse> studentCourses = studentCourseService.getStudentsPassedCourses(userId);

        List<StudentCourseDto> dtos = new ArrayList<StudentCourseDto>();

        for (StudentCourse studentCourse : studentCourses) {
            dtos.add(new StudentCourseDto(studentCourse));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    @GetMapping("/studentsByCourse/{courseId}")
    public ResponseEntity<List<StudentCourseDto>> getStudentsByCourse(@PathVariable("courseId") Long courseId) {
        List<StudentCourse> students = studentCourseService.findStudentsByCourseId(courseId);

        List<StudentCourseDto> dtos = new ArrayList<>();
        for (StudentCourse student : students) {
            dtos.add(new StudentCourseDto(student));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    // Nove rute za dokumente
    @PostMapping("/document-requests")
    public ResponseEntity<?> createDocumentRequest(@RequestBody DocumentRequestDto dto, @AuthenticationPrincipal UserDetails userDetails) {
        try {
            User student = userService.findByUsername(userDetails.getUsername());
            dto.setStudentId(student.getId());
            
            DocumentRequestDto createdRequest = documentService.createDocumentRequest(dto);
            return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/document-requests")
    public ResponseEntity<List<DocumentRequestDto>> getMyDocumentRequests(@AuthenticationPrincipal UserDetails userDetails) {
        User student = userService.findByUsername(userDetails.getUsername());
        List<DocumentRequestDto> requests = documentService.getStudentRequests(student.getId());
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
}
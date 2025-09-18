// src/main/java/rs/ac/singidunum/controller/StaffController.java

package rs.ac.singidunum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.EnrollmentRequestDto;
import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.dto.DocumentRequestDto;
import rs.ac.singidunum.model.StudentOnYear;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.StudentOnYearService;
import rs.ac.singidunum.service.StudyProgramService;
import rs.ac.singidunum.service.DocumentService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/staff")
@PreAuthorize("hasRole('STAFF')")
public class StaffController {

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StudentOnYearService studentOnYearService;

    @Autowired
    private StudyProgramService studyProgramService;

    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/enroll-student")
    public ResponseEntity<?> enrollStudent(@RequestBody EnrollmentRequestDto dto) {
        try {
            logger.info("Received enrollment request for student index: {}", dto.getStudentIndex());
            List<StudentOnYear> newEnrollments = studentOnYearService.enrollStudent(dto);

            if (newEnrollments.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to enroll student. No records were created.");
            }

            return new ResponseEntity<>(newEnrollments, HttpStatus.CREATED);

        } catch (RuntimeException e) {
            logger.error("Enrollment failed with an application error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enrollment failed. " + e.getMessage());

        } catch (Exception e) {
            logger.error("An unexpected error occurred during enrollment: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected server error occurred.");
        }
    }

    @GetMapping("/study-programs")
    public ResponseEntity<List<StudyProgramDto>> getAllStudyPrograms() {
        List<StudyProgramDto> programs = studyProgramService.findAllAsDto();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }
    
    @GetMapping("/document-requests")
    public ResponseEntity<List<DocumentRequestDto>> getPendingDocumentRequests() {
        List<DocumentRequestDto> requests = documentService.getPendingRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PutMapping("/document-requests/{requestId}/approve")
    public ResponseEntity<?> approveDocumentRequest(@PathVariable Long requestId, @AuthenticationPrincipal UserDetails userDetails) {
        try {
            User staffMember = userService.findByUsername(userDetails.getUsername());
            DocumentRequestDto approvedRequest = documentService.approveRequest(requestId, staffMember);
            return new ResponseEntity<>(approvedRequest, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/document-requests/{requestId}/reject")
    public ResponseEntity<?> rejectDocumentRequest(@PathVariable Long requestId, @AuthenticationPrincipal UserDetails userDetails) {
        try {
            User staffMember = userService.findByUsername(userDetails.getUsername());
            DocumentRequestDto rejectedRequest = documentService.rejectRequest(requestId, staffMember);
            return new ResponseEntity<>(rejectedRequest, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
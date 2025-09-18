package rs.ac.singidunum.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.DocumentRequestDto;
import rs.ac.singidunum.model.DocumentRequest;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.DocumentStatus;
import rs.ac.singidunum.repository.DocumentRequestRepository;
import rs.ac.singidunum.repository.UserRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRequestRepository documentRequestRepository;
    
    @Autowired
    private UserRepository userRepository;

    public DocumentRequestDto createDocumentRequest(DocumentRequestDto dto) {
        User student = userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        DocumentRequest request = new DocumentRequest();
        request.setStudent(student);
        request.setDocumentType(dto.getDocumentType());
        request.setPurpose(dto.getPurpose());
        request.setStatus(DocumentStatus.PENDING);
        request.setRequestDate(LocalDateTime.now());
        
        documentRequestRepository.save(request);
        
        return convertToDto(request);
    }

    public List<DocumentRequestDto> getPendingRequests() {
        return documentRequestRepository.findByStatus(DocumentStatus.PENDING).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public List<DocumentRequestDto> getStudentRequests(Long studentId) {
        return documentRequestRepository.findByStudentId(studentId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public DocumentRequestDto approveRequest(Long requestId, User staffMember) {
        DocumentRequest request = documentRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Document request not found"));

        if (request.getStatus() != DocumentStatus.PENDING) {
            throw new RuntimeException("Request has already been processed.");
        }

        // Simulating PDF generation and saving
        String downloadLink = "/documents/" + request.getStudent().getId() + "/" + request.getDocumentType().name() + "_" + LocalDateTime.now().getNano() + ".pdf";
        
        request.setStatus(DocumentStatus.APPROVED);
        request.setCompletionDate(LocalDateTime.now());
        request.setDownloadLink(downloadLink);
        request.setStaffMember(staffMember);
        
        documentRequestRepository.save(request);
        
        return convertToDto(request);
    }
    
    public DocumentRequestDto rejectRequest(Long requestId, User staffMember) {
        DocumentRequest request = documentRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Document request not found"));

        if (request.getStatus() != DocumentStatus.PENDING) {
            throw new RuntimeException("Request has already been processed.");
        }

        request.setStatus(DocumentStatus.REJECTED);
        request.setCompletionDate(LocalDateTime.now());
        request.setStaffMember(staffMember);
        
        documentRequestRepository.save(request);
        
        return convertToDto(request);
    }
    
    private DocumentRequestDto convertToDto(DocumentRequest request) {
        DocumentRequestDto dto = new DocumentRequestDto();
        dto.setId(request.getId());
        dto.setDocumentType(request.getDocumentType());
        dto.setPurpose(request.getPurpose());
        dto.setStatus(request.getStatus());
        dto.setRequestDate(request.getRequestDate());
        dto.setCompletionDate(request.getCompletionDate());
        dto.setDownloadLink(request.getDownloadLink());
        
        if (request.getStudent() != null) {
            dto.setStudentId(request.getStudent().getId());
            dto.setStudentUsername(request.getStudent().getUsername());
            dto.setStudentFullName(request.getStudent().getName() + " " + request.getStudent().getSurname());
        }
        
        if (request.getStaffMember() != null) {
            dto.setStaffUsername(request.getStaffMember().getUsername());
        }
        
        return dto;
    }
}
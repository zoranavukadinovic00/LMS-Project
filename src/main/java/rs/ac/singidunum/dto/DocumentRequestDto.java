package rs.ac.singidunum.dto;

import java.time.LocalDateTime;

import rs.ac.singidunum.model.enums.DocumentStatus;
import rs.ac.singidunum.model.enums.DocumentType;

public class DocumentRequestDto {
    private Long id;
    private Long studentId;
    private String studentUsername;
    private String studentFullName;
    private DocumentType documentType;
    private String purpose;
    private DocumentStatus status;
    private LocalDateTime requestDate;
    private LocalDateTime completionDate;
    private String downloadLink;
    private String staffUsername;

    public DocumentRequestDto() {
    }

    public DocumentRequestDto(Long id, Long studentId, String studentUsername, String studentFullName, DocumentType documentType,
            String purpose, DocumentStatus status, LocalDateTime requestDate, LocalDateTime completionDate,
            String downloadLink, String staffUsername) {
        this.id = id;
        this.studentId = studentId;
        this.studentUsername = studentUsername;
        this.studentFullName = studentFullName;
        this.documentType = documentType;
        this.purpose = purpose;
        this.status = status;
        this.requestDate = requestDate;
        this.completionDate = completionDate;
        this.downloadLink = downloadLink;
        this.staffUsername = staffUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }
    
    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

}
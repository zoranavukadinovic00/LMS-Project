package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.model.DocumentRequest;
import rs.ac.singidunum.model.enums.DocumentStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRequestRepository extends JpaRepository<DocumentRequest, Long> {

    List<DocumentRequest> findByStudentId(Long studentId);
    List<DocumentRequest> findByStatus(DocumentStatus status);
}
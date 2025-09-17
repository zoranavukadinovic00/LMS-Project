package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.StudentEvaluation;

@Repository
public interface StudentEvaluationRepository extends JpaRepository<StudentEvaluation, Long> {
    
    // ✨ Dodata metoda za pronalaženje evaluacija po studentu
    List<StudentEvaluation> findByStudentCourse_Student_Id(Long studentId);
}
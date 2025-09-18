package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.ExamApplication;

@Repository
public interface ExamApplicationRepository extends JpaRepository<ExamApplication, Long> {

    List<ExamApplication> findByStudent_Id(Long studentId);
}
package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.ExamTerm;

@Repository
public interface ExamTermRepository extends JpaRepository<ExamTerm, Long> {

	List<ExamTerm> findByExamPeriodId(Long examPeriodId);

    List<ExamTerm> findByNameContainingIgnoreCase(String name);
}

package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.EvaluationInstrument;

@Repository
public interface EvaluationInstrumentRepository extends JpaRepository<EvaluationInstrument, Long> {

	@Query("SELECT ei FROM EvaluationInstrument ei WHERE ei.course.id = :courseId")
	List<EvaluationInstrument> findEvaluationInstrumentsByCourseId(@Param("courseId") Long courseId);
}

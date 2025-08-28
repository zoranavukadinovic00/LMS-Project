package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Syllabus;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Long> {
	
	@Query("SELECT s FROM Syllabus s WHERE s.course.id = :courseId")
	List<Syllabus> findSyllabusByCourseId(@Param("courseId") Long courseId);

}

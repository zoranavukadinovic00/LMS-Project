package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.StudentOnYear;

@Repository
public interface StudentOnYearRepository extends JpaRepository<StudentOnYear, Long> {
	@Query("""
			    SELECT s FROM StudentOnYear s
			    WHERE (:name IS NULL OR LOWER(s.student.name) LIKE LOWER(CONCAT('%', :name, '%')))
			      AND (:surname IS NULL OR LOWER(s.student.surname) LIKE LOWER(CONCAT('%', :surname, '%')))
			      AND (:index IS NULL OR s.index LIKE CONCAT('%', :index, '%'))
			      AND (:enrollmentYear IS NULL OR s.dateOfEnrollment = :enrollmentYear)
			      AND (:studyYear IS NULL OR s.year = :studyYear)
			      AND (:minAverageGrade IS NULL OR s.averageGrade >= :minAverageGrade)
                  AND (:maxAverageGrade IS NULL OR s.averageGrade <= :maxAverageGrade)

			      

			""")
	Page<StudentOnYear> searchStudents(@Param("name") String name, @Param("surname") String surname,
			@Param("index") String index, @Param("enrollmentYear") Integer enrollmentYear,
			@Param("studyYear") Integer studyYear, @Param("minAverageGrade") Double minAverageGrade,
            @Param("maxAverageGrade") Double maxAverageGrade, Pageable pageable);
	
    List<StudentOnYear> findByStudent_Id(Long studentId);
	
	

}

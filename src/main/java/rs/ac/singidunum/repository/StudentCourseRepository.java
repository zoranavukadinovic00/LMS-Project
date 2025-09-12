package rs.ac.singidunum.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	@Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.status = 'ENROLLED'")
	List<StudentCourse> findEnrolledCoursesByStudentId(@Param("studentId") Long studentId);
	
	@Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.status = 'PASSED'")
	List<StudentCourse> findPassedCoursesByStudentId(@Param("studentId") Long studentId);

	Optional<StudentCourse> findFirstByStudentId_IdAndCourseId_Id(Long studentId, Long courseId);

	@Query("SELECT sc FROM StudentCourse sc WHERE sc.course.id = :courseId")
	List<StudentCourse> findStudentsByCourseId(@Param("courseId") Long courseId);


}

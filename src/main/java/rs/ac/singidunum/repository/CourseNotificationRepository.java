package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.CourseNotification;

@Repository
public interface CourseNotificationRepository extends JpaRepository<CourseNotification, Long> {

	@Query("""
			    SELECT cn
			    FROM CourseNotification cn
			    WHERE cn.course IN (
			        SELECT sc.course
			        FROM StudentCourse sc
			        WHERE sc.student.id = :studentId AND sc.status = 'ENROLLED'
			    )
			""")
	List<CourseNotification> findAllNotificationsByStudentId(@Param("studentId") Long studentId);

	@Query("""
		    SELECT cn
		    FROM CourseNotification cn
		    WHERE cn.course IN (
		        SELECT pc.course
		        FROM ProfessorCourse pc
		        WHERE pc.professor.id = :professorId
		    )
		""")
		List<CourseNotification> findAllByProfessorId(@Param("professorId") Long professorId);

}

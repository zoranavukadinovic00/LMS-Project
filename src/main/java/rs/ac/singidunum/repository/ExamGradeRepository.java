package rs.ac.singidunum.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.ExamGrade;

@Repository
public interface ExamGradeRepository extends JpaRepository<ExamGrade, Long>{
	
	List<ExamGrade> findByCourse_Id(Long courseId);

    List<ExamGrade> findByExamTermId(Long examTermId);

    Optional<ExamGrade> findByStudentIdAndCourseIdAndExamTermId(
        Long studentId, Long courseId, Long examTermId
    );

    @Query("SELECT eg FROM ExamGrade eg " +
           "JOIN eg.course c " +
           "JOIN ProfessorCourse pc ON pc.course.id = c.id " +
           "WHERE pc.professor.id = :professorId")
    List<ExamGrade> findByCourseProfessorId(@Param("professorId") Long professorId);
}

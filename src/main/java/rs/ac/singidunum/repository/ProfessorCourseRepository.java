package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.ProfessorCourse;

@Repository
public interface ProfessorCourseRepository extends JpaRepository<ProfessorCourse, Long> {

    @Query("SELECT pc FROM ProfessorCourse pc WHERE pc.professor.id = :professorId")
    List<ProfessorCourse> findAllByProfessorId(@Param("professorId") Long professorId);

    List<ProfessorCourse> findByProfessor_Id(Long professorId);
    
    List<ProfessorCourse> findByCourseId(Long courseId);
    
    boolean existsByProfessorIdAndCourseId(Long professorId, Long courseId);
}
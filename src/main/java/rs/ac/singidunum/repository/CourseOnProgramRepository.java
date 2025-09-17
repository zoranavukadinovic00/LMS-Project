package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.CourseOnProgram;

@Repository
public interface CourseOnProgramRepository extends JpaRepository<CourseOnProgram, Long> {

    @Query("SELECT cop.course FROM CourseOnProgram cop WHERE cop.studyProgram.id = :programId")
    List<Course> findCoursesByStudyProgramId(@Param("programId") Long programId);
    
    // Dodata metoda za kaskadno brisanje
    void deleteByStudyProgramId(Long studyProgramId);
}
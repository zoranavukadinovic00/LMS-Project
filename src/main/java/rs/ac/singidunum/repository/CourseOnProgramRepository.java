package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.CourseOnProgram;

@Repository
public interface CourseOnProgramRepository extends JpaRepository<CourseOnProgram, Long> {
    
    List<CourseOnProgram> findByStudyProgram_Id(Long studyProgramId);

    void deleteByStudyProgram_Id(Long studyProgramId);

    @Query("SELECT cop FROM CourseOnProgram cop WHERE cop.studyProgram.id = :studyProgramId AND cop.year = :year AND cop.course.mandatory = :isMandatory")
    List<CourseOnProgram> findByStudyProgramIdAndYearAndCourseMandatory(
        @Param("studyProgramId") Long studyProgramId,
        @Param("year") int year,
        @Param("isMandatory") boolean isMandatory);
}
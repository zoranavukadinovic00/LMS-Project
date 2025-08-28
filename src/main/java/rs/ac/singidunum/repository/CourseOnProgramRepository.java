package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.CourseOnProgram;
@Repository
public interface CourseOnProgramRepository extends JpaRepository<CourseOnProgram, Long>{

}

package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.StudyProgram;
@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

}

package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

	@Autowired
    private StudyProgramRepository studyProgramrepository;

    public List<StudyProgram> findAll() {
        return studyProgramrepository.findAll();
    }

    public StudyProgram findOne(Long id) {
        return studyProgramrepository.findById(id).orElse(null);
    }

    public StudyProgram save(StudyProgram studyProgram) {
        return studyProgramrepository.save(studyProgram);
    }

    public void delete(Long id) {
    	studyProgramrepository.deleteById(id);
    }

    public void delete(StudyProgram studyProgram) {
    	studyProgramrepository.delete(studyProgram);
    }
    public List<StudyProgram> getAllByFacultyId(Long facultyId) {
        return studyProgramrepository.findByFaculty_IdOrderByNameAsc(facultyId);
    }
}

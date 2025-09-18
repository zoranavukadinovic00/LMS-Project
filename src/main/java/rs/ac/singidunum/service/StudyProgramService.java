package rs.ac.singidunum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.repository.CourseOnProgramRepository;
import rs.ac.singidunum.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

    @Autowired
    private StudyProgramRepository studyProgramrepository;
    
    @Autowired
    private CourseOnProgramRepository courseOnProgramRepository;

    public List<StudyProgram> findAll() {
        return studyProgramrepository.findAll();
    }
    
    public List<StudyProgramDto> findAllAsDto() {
        return studyProgramrepository.findAll().stream()
                .map(StudyProgramDto::new)
                .collect(Collectors.toList());
    }

    public StudyProgram findOne(Long id) {
        return studyProgramrepository.findById(id).orElse(null);
    }

    @Transactional
    public StudyProgram save(StudyProgram studyProgram) {
        return studyProgramrepository.save(studyProgram);
    }
    
    @Transactional
    public void delete(Long id) {
        courseOnProgramRepository.deleteByStudyProgram_Id(id);
        studyProgramrepository.deleteById(id);
    }

    public List<StudyProgram> getAllByFacultyId(Long facultyId) {
        return studyProgramrepository.findByFaculty_IdOrderByNameAsc(facultyId);
    }
}
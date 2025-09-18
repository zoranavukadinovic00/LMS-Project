package rs.ac.singidunum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.CourseOnProgram;
import rs.ac.singidunum.repository.CourseOnProgramRepository;

@Service
public class CourseOnProgramService {
    
    @Autowired
    private CourseOnProgramRepository courseOnProgramRepository; 

    public List<CourseOnProgram> findAll() {
        return courseOnProgramRepository.findAll();
    }

    public CourseOnProgram findOne(Long id) {
        return courseOnProgramRepository.findById(id).orElse(null);
    }

    public CourseOnProgram save(CourseOnProgram courseOnProgram) {
        return courseOnProgramRepository.save(courseOnProgram);
    }

    public void delete(Long id) {
        courseOnProgramRepository.deleteById(id);
    }

    public void delete(CourseOnProgram courseOnProgram) {
        courseOnProgramRepository.delete(courseOnProgram);
    }
    public CourseOnProgramService(CourseOnProgramRepository repository) {
        this.courseOnProgramRepository = repository;
    }

    public List<Course> getCoursesByProgram(Long programId) {
        return courseOnProgramRepository.findByStudyProgram_Id(programId).stream()
            .map(CourseOnProgram::getCourse)
            .collect(Collectors.toList());
    }
}
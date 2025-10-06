package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.CourseOnProgram;
import rs.ac.singidunum.repository.CourseOnProgramRepository;
import rs.ac.singidunum.repository.CourseRepository; 

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseOnProgramRepository courseOnProgramRepository;
    
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findOne(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public List<Course> getAllByProgramId(Long programId) {
        List<CourseOnProgram> coursesOnProgram = courseOnProgramRepository.findByStudyProgram_Id(programId);
        return coursesOnProgram.stream()
            .map(CourseOnProgram::getCourse)
            .collect(Collectors.toList());
    }
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}
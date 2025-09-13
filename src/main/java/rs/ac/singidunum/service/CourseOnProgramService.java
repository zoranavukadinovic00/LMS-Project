package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.CourseOnProgram;
import rs.ac.singidunum.repository.CourseOnProgramRepository;
@Service
public class CourseOnProgramService {
	
	@Autowired
    private CourseOnProgramRepository courseOnProgramEepository;

    public List<CourseOnProgram> findAll() {
        return courseOnProgramEepository.findAll();
    }

    public CourseOnProgram findOne(Long id) {
        return courseOnProgramEepository.findById(id).orElse(null);
    }

    public CourseOnProgram save(CourseOnProgram courseOnProgram) {
        return courseOnProgramEepository.save(courseOnProgram);
    }

    public void delete(Long id) {
    	courseOnProgramEepository.deleteById(id);
    }

    public void delete(CourseOnProgram courseOnProgram) {
    	courseOnProgramEepository.delete(courseOnProgram);
    }
    public CourseOnProgramService(CourseOnProgramRepository repository) {
        this.courseOnProgramEepository = repository;
    }

    public List<Course> getCoursesByProgram(Long programId) {
        return courseOnProgramEepository.findCoursesByStudyProgramId(programId);
    }

}

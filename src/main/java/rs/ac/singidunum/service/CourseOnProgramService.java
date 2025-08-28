package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.CourseOnProgram;
import rs.ac.singidunum.repository.CourseOnProgramRepository;
@Service
public class CourseOnProgramService {
	
	@Autowired
    private CourseOnProgramRepository courseOnProgramepository;

    public List<CourseOnProgram> findAll() {
        return courseOnProgramepository.findAll();
    }

    public CourseOnProgram findOne(Long id) {
        return courseOnProgramepository.findById(id).orElse(null);
    }

    public CourseOnProgram save(CourseOnProgram courseOnProgram) {
        return courseOnProgramepository.save(courseOnProgram);
    }

    public void delete(Long id) {
    	courseOnProgramepository.deleteById(id);
    }

    public void delete(CourseOnProgram courseOnProgram) {
    	courseOnProgramepository.delete(courseOnProgram);
    }

}

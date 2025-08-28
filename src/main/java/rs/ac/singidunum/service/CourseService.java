package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.repository.CourseRepository;
@Service
public class CourseService {
	
	@Autowired
    private CourseRepository courseRepository;
	
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

}

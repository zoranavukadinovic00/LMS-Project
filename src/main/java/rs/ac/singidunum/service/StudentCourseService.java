package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.repository.StudentCourseRepository;
@Service
public class StudentCourseService {
	
	@Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> findAll() {
        return studentCourseRepository.findAll();
    }

    public StudentCourse findOne(Long id) {
        return studentCourseRepository.findById(id).orElse(null);
    }

    public StudentCourse save(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public void delete(Long id) {
    	studentCourseRepository.deleteById(id);
    }

    public void delete(StudentCourse studentCourse) {
    	studentCourseRepository.delete(studentCourse);
    }
    
    public List<StudentCourse> getStudentsEnrolledCourses(long studentId){
    	return studentCourseRepository.findEnrolledCoursesByStudentId(studentId);
    }
    
    public List<StudentCourse> getStudentsPassedCourses(long studentId){
    	return studentCourseRepository.findPassedCoursesByStudentId(studentId);
    }

    

   
}

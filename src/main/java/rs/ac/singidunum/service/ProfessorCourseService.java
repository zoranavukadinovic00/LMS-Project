package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.ProfessorCourse;
import rs.ac.singidunum.repository.ProfessorCourseRepository;
@Service
public class ProfessorCourseService {

	@Autowired
    private ProfessorCourseRepository professorCourseRepository;

    public List<ProfessorCourse> findAll() {
        return professorCourseRepository.findAll();
    }

    public ProfessorCourse findOne(Long id) {
        return professorCourseRepository.findById(id).orElse(null);
    }

    public ProfessorCourse save(ProfessorCourse professorCourse) {
        return professorCourseRepository.save(professorCourse);
    }

    public void delete(Long id) {
    	professorCourseRepository.deleteById(id);
    }

    public void delete(ProfessorCourse professorCourse) {
    	professorCourseRepository.delete(professorCourse);
    }
    
    public List<ProfessorCourse> getCoursesByProfessorId(Long professorId) {
        return professorCourseRepository.findAllByProfessorId(professorId);
    }

    
}

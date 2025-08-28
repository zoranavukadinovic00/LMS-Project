package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Syllabus;
import rs.ac.singidunum.repository.SyllabusRepository;

@Service
public class SyllabusService {

	@Autowired
    private SyllabusRepository syllabusRepository;

    public List<Syllabus> findAll() {
        return syllabusRepository.findAll();
    }

    public Syllabus findOne(Long id) {
        return syllabusRepository.findById(id).orElse(null);
    }

    public Syllabus save(Syllabus syllabus) {
        return syllabusRepository.save(syllabus);
    }

    public void delete(Long id) {
    	syllabusRepository.deleteById(id);
    }

    public void delete(Syllabus syllabus) {
    	syllabusRepository.delete(syllabus);
    }
    public List<Syllabus> getAllByCourseId(long courseId){
    	return syllabusRepository.findSyllabusByCourseId(courseId);
    }
    
}

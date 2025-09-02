package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.SyllabysDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.Syllabus;
import rs.ac.singidunum.repository.CourseRepository;
import rs.ac.singidunum.repository.SyllabusRepository;

@Service
public class SyllabusService {

	@Autowired
    private SyllabusRepository syllabusRepository;
	
	@Autowired
    private CourseRepository courseRepository;

    public List<Syllabus> findAll() {
        return syllabusRepository.findAll();
    }

    public Syllabus findOne(Long id) {
        return syllabusRepository.findById(id).orElse(null);
    }

    public Syllabus save(SyllabysDto dto) {
    	Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
    	if(course == null) {
    		return null;
    	}
    	
    	Syllabus syllabys = new Syllabus();
    	
    	syllabys.setDescription(dto.getDescription());
    	syllabys.setCourse(course);

        return syllabusRepository.save(syllabys);
    }
    
    public Syllabus update(SyllabysDto dto) {
    	Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
    	if(course == null) {
    		return null;
    	}
    	
    	Syllabus syllabys = syllabusRepository.findById(dto.getId()).orElse(null);
    	if(syllabys == null) {
    		return null;
    	}
    	
    	syllabys.setDescription(dto.getDescription());
    	syllabys.setCourse(course);

        return syllabusRepository.save(syllabys);
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

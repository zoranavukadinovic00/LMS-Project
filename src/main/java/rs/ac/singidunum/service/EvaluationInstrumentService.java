package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.EvaluationInstrumentDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.EvaluationInstrument;
import rs.ac.singidunum.repository.CourseRepository;
import rs.ac.singidunum.repository.EvaluationInstrumentRepository;

@Service
public class EvaluationInstrumentService {

	@Autowired
    private EvaluationInstrumentRepository evaluationInstrumentRepository;
	
	@Autowired
    private CourseRepository courseRepository;

    public List<EvaluationInstrument> findAll() {
        return evaluationInstrumentRepository.findAll();
    }

    public EvaluationInstrument findOne(Long id) {
        return evaluationInstrumentRepository.findById(id).orElse(null);
    }

    public EvaluationInstrument save(EvaluationInstrumentDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        EvaluationInstrument instrument = new EvaluationInstrument();
        instrument.setName(dto.getName());
        instrument.setPoints(dto.getPoints());
        instrument.setCourse(course);

        return evaluationInstrumentRepository.save(instrument);
    }

    public EvaluationInstrument update(EvaluationInstrumentDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        EvaluationInstrument instrument = evaluationInstrumentRepository.findById(dto.getId()).orElse(null);
        if (instrument == null) {
            return null;
        }

        instrument.setName(dto.getName());
        instrument.setPoints(dto.getPoints());
        instrument.setCourse(course);

        return evaluationInstrumentRepository.save(instrument);
    }

    public void delete(Long id) {
        evaluationInstrumentRepository.deleteById(id);
    }

    public void delete(EvaluationInstrument evaluationInstrument) {
        evaluationInstrumentRepository.delete(evaluationInstrument);
    }
    
    public List<EvaluationInstrument> getAllByCourseId(long courseId){
    	return evaluationInstrumentRepository.findEvaluationInstrumentsByCourseId(courseId);
    }
}

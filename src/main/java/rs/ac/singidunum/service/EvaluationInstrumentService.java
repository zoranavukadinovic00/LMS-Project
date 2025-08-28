package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.EvaluationInstrument;
import rs.ac.singidunum.repository.EvaluationInstrumentRepository;

@Service
public class EvaluationInstrumentService {

	@Autowired
    private EvaluationInstrumentRepository evaluationInstrumentRepository;

    public List<EvaluationInstrument> findAll() {
        return evaluationInstrumentRepository.findAll();
    }

    public EvaluationInstrument findOne(Long id) {
        return evaluationInstrumentRepository.findById(id).orElse(null);
    }

    public EvaluationInstrument save(EvaluationInstrument evaluationInstrument) {
        return evaluationInstrumentRepository.save(evaluationInstrument);
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

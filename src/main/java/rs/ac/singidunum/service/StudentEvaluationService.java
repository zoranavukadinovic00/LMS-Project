package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.StudentEvaluation;
import rs.ac.singidunum.repository.StudentEvaluationRepository;

@Service
public class StudentEvaluationService {
	
	@Autowired
    private StudentEvaluationRepository studentEvaluationRepository;
	
	public List<StudentEvaluation> findAll() {
        return studentEvaluationRepository.findAll();
    }

    public StudentEvaluation findOne(Long id) {
        return studentEvaluationRepository.findById(id).orElse(null);
    }

    public StudentEvaluation save(StudentEvaluation studentEvaluation) {
        return studentEvaluationRepository.save(studentEvaluation);
    }

    public void delete(Long id) {
    	studentEvaluationRepository.deleteById(id);
    }

    public void delete(StudentEvaluation studentEvaluation) {
    	studentEvaluationRepository.delete(studentEvaluation);
    }
}

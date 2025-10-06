package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.ExamTerm;
import rs.ac.singidunum.repository.ExamTermRepository;

@Service
public class ExamTermService {
	
	@Autowired
    private ExamTermRepository examTermRepository;

    public List<ExamTerm> getAllTerms() {
        return examTermRepository.findAll();
    }

    public Optional<ExamTerm> getTermById(Long id) {
        return examTermRepository.findById(id);
    }

    public List<ExamTerm> getTermsByExamPeriod(Long periodId) {
        return examTermRepository.findByExamPeriodId(periodId);
    }

    public ExamTerm saveTerm(ExamTerm term) {
        return examTermRepository.save(term);
    }

    public void deleteTerm(Long id) {
        examTermRepository.deleteById(id);
    }

}

package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.ExamPeriod;
import rs.ac.singidunum.repository.ExamPeriodRepository;
@Service
public class ExamPeriodService {
	
	@Autowired
    private ExamPeriodRepository examPeriodRepository;

    public List<ExamPeriod> getAllPeriods() {
        return examPeriodRepository.findAll();
    }

    public Optional<ExamPeriod> getPeriodById(Long id) {
        return examPeriodRepository.findById(id);
    }

    public ExamPeriod savePeriod(ExamPeriod period) {
        return examPeriodRepository.save(period);
    }

    public void deletePeriod(Long id) {
        examPeriodRepository.deleteById(id);
    }

}

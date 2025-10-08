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

    /**
     * Dohvata SVE ispitne rokove. (Osnovni metod za repo)
     */
    public List<ExamPeriod> findAllPeriods() {
        System.out.println("LOG A [ExamPeriodService]: Fetching ALL periods from DB (unfiltered).");
        return examPeriodRepository.findAll();
    }
    
    /**
     * IMPLEMENTIRANA NEDOSTAJUĆA METODA:
     * Koristi se za Admin/Generalni dohvat svih rokova i rešava kompilacionu grešku.
     * S obzirom na to da trenutno ne radimo filtriranje, samo pozivamo findAllPeriods().
     */
    public List<ExamPeriod> findAllForAdmin() {
        return findAllPeriods();
    }
    
    // Metode ostaju nepromenjene
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
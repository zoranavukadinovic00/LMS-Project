package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.ExamPeriod;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
    
    // Uklonjen @Query i findActivePeriods(). Koristi se samo standardni findAll()
    // unutar servisa, a filtriranje se obavlja u Javi.
}
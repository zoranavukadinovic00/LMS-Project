package rs.ac.singidunum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.University;
@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    
    // ✨ Dodata metoda za pronalaženje univerziteta po rektoru
    Optional<University> findByRector_Id(Long rectorId);
}
package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.University;
@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}

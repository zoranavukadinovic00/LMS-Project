package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}

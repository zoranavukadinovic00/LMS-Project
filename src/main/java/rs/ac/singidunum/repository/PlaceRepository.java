package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Place;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}

package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	List<Faculty> findAllByUniversity_Id(Long universityId);
}

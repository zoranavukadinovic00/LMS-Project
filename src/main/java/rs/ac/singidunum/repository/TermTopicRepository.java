package rs.ac.singidunum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.TermTopic;
@Repository
public interface TermTopicRepository extends JpaRepository<TermTopic, Long> {

	List<TermTopic> findByCourseIdOrderByTermNumberAscIdAsc(Long courseId);
	
}

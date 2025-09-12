package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.TermTopicDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.TermTopic;
import rs.ac.singidunum.repository.CourseRepository;
import rs.ac.singidunum.repository.TermTopicRepository;

@Service
public class TermTopicService {

    @Autowired
    private TermTopicRepository termTopicRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<TermTopic> findAll() {
        return termTopicRepository.findAll();
    }

    public TermTopic findOne(Long id) {
        return termTopicRepository.findById(id).orElse(null);
    }

    public TermTopic save(TermTopicDto dto) {
        
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        TermTopic termTopic = new TermTopic();
        termTopic.setDescription(dto.getDescription());
        termTopic.setTermNumber(dto.getTermNumber()); 
        termTopic.setCourse(course);

        return termTopicRepository.save(termTopic);
    }

    public TermTopic update(TermTopicDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        TermTopic termTopic = termTopicRepository.findById(dto.getId()).orElse(null);
        if (termTopic == null) {
            return null;
        }

        termTopic.setDescription(dto.getDescription());
        termTopic.setTermNumber(dto.getTermNumber()); 
        termTopic.setCourse(course);

        return termTopicRepository.save(termTopic);
    }

    public void delete(Long id) {
        termTopicRepository.deleteById(id);
    }

    public void delete(TermTopic termTopic) {
        termTopicRepository.delete(termTopic);
    }

    public List<TermTopic> getAllByCourseId(Long courseId) {
        return termTopicRepository.findByCourseIdOrderByTermNumberAscIdAsc(courseId);
    }
}

package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.ExamPeriodDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.ExamPeriod;
import rs.ac.singidunum.repository.CourseRepository;
import rs.ac.singidunum.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService {
	
	@Autowired
    private ExamPeriodRepository examPeriodRepository;
	@Autowired
    private CourseRepository courseRepository;
	
	public List<ExamPeriod> findAll() {
        return examPeriodRepository.findAll();
    }

    public ExamPeriod findOne(Long id) {
        return examPeriodRepository.findById(id).orElse(null);
    }

    public ExamPeriod save(ExamPeriod examPeriod) {
        return examPeriodRepository.save(examPeriod);
    }
    
    public ExamPeriod save(ExamPeriodDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        ExamPeriod examPeriod = new ExamPeriod();
        examPeriod.setCourse(course);
        examPeriod.setStartDate(dto.getStartDate());
        examPeriod.setEndDate(dto.getEndDate());

        return examPeriodRepository.save(examPeriod);
    }

    public ExamPeriod update(ExamPeriodDto dto) {
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if (course == null) {
            return null;
        }

        ExamPeriod examPeriod = examPeriodRepository.findById(dto.getId()).orElse(null);
        if (examPeriod == null) {
            return null;
        }

        examPeriod.setCourse(course);
        examPeriod.setStartDate(dto.getStartDate());
        examPeriod.setEndDate(dto.getEndDate());

        return examPeriodRepository.save(examPeriod);
    }

    public void delete(Long id) {
        examPeriodRepository.deleteById(id);
    }

    public void delete(ExamPeriod examPeriod) {
        examPeriodRepository.delete(examPeriod);
    }

}

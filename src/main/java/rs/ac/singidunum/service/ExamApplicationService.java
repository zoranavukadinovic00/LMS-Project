package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.ExamApplication;
import rs.ac.singidunum.model.ExamTerm;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.ExamApplicationStatus;
import rs.ac.singidunum.repository.ExamApplicationRepository;

@Service
public class ExamApplicationService {
	
	@Autowired
    private ExamApplicationRepository examApplicationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamTermService examTermService;

    public List<ExamApplication> getAllApplications() {
        return examApplicationRepository.findAll();
    }

    public Optional<ExamApplication> getApplicationById(Long id) {
        return examApplicationRepository.findById(id);
    }

    public List<ExamApplication> getApplicationsByCourse(Long courseId) {
        return examApplicationRepository.findByCourseId(courseId);
    }

    public List<ExamApplication> getApplicationsByStudent(Long studentId) {
        return examApplicationRepository.findByStudent_Id(studentId);
    }

    public List<ExamApplication> getApplicationsByTerm(Long termId) {
        return examApplicationRepository.findByExamTermId(termId);
    }

    public List<ExamApplication> getStudentsForCourse(Long courseId) {
        return examApplicationRepository.findByCourseId(courseId);
    }

    public ExamApplication applyForExam(Long studentId, Long termId) {
        User student = userService.getUserById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        ExamTerm term = examTermService.getTermById(termId)
                .orElseThrow(() -> new RuntimeException("Exam term not found"));
        
        ExamApplication app = new ExamApplication();
        app.setStudent(student);
        app.setExamTerm(term);
        app.setCourse(term.getCourse());
        app.setStatus(ExamApplicationStatus.APPLIED);
        app.setPoints(0);
        
        return examApplicationRepository.save(app);
    }

    public ExamApplication saveApplication(ExamApplication app) {
        return examApplicationRepository.save(app);
    }

    public void deleteApplication(Long id) {
        examApplicationRepository.deleteById(id);
    }
    public ExamApplication updateApplication(ExamApplication app) {
        return examApplicationRepository.save(app);
    }
}

	    
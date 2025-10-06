package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.ExamGrade;
import rs.ac.singidunum.repository.ExamGradeRepository;

@Service
public class ExamGradeService {
	
	@Autowired
    private ExamGradeRepository examGradeRepository;

    public List<ExamGrade> getAllGrades() {
        return examGradeRepository.findAll();
    }

    public Optional<ExamGrade> getGradeById(Long id) {
        return examGradeRepository.findById(id);
    }

    public List<ExamGrade> getGradesByTermId(Long termId) {
        return examGradeRepository.findByExamTermId(termId);
    }

    public List<ExamGrade> getGradesByCourseId(Long courseId) {
        return examGradeRepository.findByCourse_Id(courseId);
    }

    public List<ExamGrade> getGradesByProfessorId(Long professorId) {
        return examGradeRepository.findByCourseProfessorId(professorId);
    }

    public boolean gradeExists(Long studentId, Long courseId, Long termId) {
        return examGradeRepository.findByStudentIdAndCourseIdAndExamTermId(studentId, courseId, termId)
                .isPresent();
    }

    public ExamGrade saveGrade(ExamGrade grade) {
        return examGradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        examGradeRepository.deleteById(id);
    }
}

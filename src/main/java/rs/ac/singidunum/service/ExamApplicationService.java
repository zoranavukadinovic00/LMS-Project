package rs.ac.singidunum.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.ExamApplicationDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.ExamApplication;
import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.ExamApplicationStatus;
import rs.ac.singidunum.repository.CourseRepository;
import rs.ac.singidunum.repository.ExamApplicationRepository;
import rs.ac.singidunum.repository.StudentCourseRepository;
import rs.ac.singidunum.repository.UserRepository;

@Service
public class ExamApplicationService {

    @Autowired
    private ExamApplicationRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<ExamApplication> findAll() {
        return examRepository.findAll();
    }

    public ExamApplication findOne(Long id) {
        return examRepository.findById(id).orElse(null);
    }

    public ExamApplication save(ExamApplicationDto examApplicationDto) {
        User user = userRepository.findById(examApplicationDto.getStudentId()).orElse(null);
        if(user == null) {
            return null;
        }

        Course course = courseRepository.findById(examApplicationDto.getCourseId()).orElse(null);
        if(course == null) {
            return null;
        }
        
        // ✨ Ispravljeno: promenjen naziv metode kako bi se poklapao sa repozitorijumom
        Optional<StudentCourse> optionalStudentCourse = studentCourseRepository.findFirstByStudent_IdAndCourse_Id(user.getId(), course.getId());
        
        if (optionalStudentCourse.isEmpty()) {
            return null;
        }
        
        StudentCourse studentCourse = optionalStudentCourse.get();

        //fali rok
        ExamApplication examApplication = new ExamApplication();
        examApplication.setStudent(user);
        examApplication.setCourse(course);
        examApplication.setStatus(ExamApplicationStatus.APPLIED);
        examApplication.setPoints(0);
        examApplication.setApplicationDate(LocalDateTime.now());
        examRepository.save(examApplication);
        
        studentCourse.setNumberOfExamApplications(studentCourse.getNumberOfExamApplications() + 1);
        studentCourseRepository.save(studentCourse);
        
        return examApplication;
    }

    public void delete(Long id) {
        examRepository.deleteById(id);
    }

    public void delete(ExamApplication examApplication) {
        examRepository.delete(examApplication);
    }
}
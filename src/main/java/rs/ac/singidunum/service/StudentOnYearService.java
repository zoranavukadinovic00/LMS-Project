// src/main/java/rs/ac/singidunum/service/StudentOnYearService.java

package rs.ac.singidunum.service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import rs.ac.singidunum.dto.EnrollmentRequestDto;
import rs.ac.singidunum.dto.StudentDetailsDto;
import rs.ac.singidunum.dto.StudentOnYearDto;
import rs.ac.singidunum.model.CourseOnProgram;
import rs.ac.singidunum.model.StudentCourse;
import rs.ac.singidunum.model.StudentOnYear;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.EnrollmentStatus;
import rs.ac.singidunum.repository.CourseOnProgramRepository;
import rs.ac.singidunum.repository.StudentCourseRepository;
import rs.ac.singidunum.repository.StudentOnYearRepository;
import rs.ac.singidunum.repository.StudyProgramRepository;
import rs.ac.singidunum.repository.UserRepository;

@Service
public class StudentOnYearService {

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    private CourseOnProgramRepository courseOnProgramRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentOnYear> findAll() {
        return studentOnYearRepository.findAll();
    }

    public StudentOnYear findOne(Long id) {
        return studentOnYearRepository.findById(id).orElse(null);
    }

    public StudentOnYear save(StudentOnYear studentOnYear) {
        return studentOnYearRepository.save(studentOnYear);
    }

    public void delete(Long id) {
        studentOnYearRepository.deleteById(id);
    }

    public void delete(StudentOnYear studentOnYear) {
        studentOnYearRepository.delete(studentOnYear);
    }

    public Page<StudentOnYear> searchStudents(
            String name,
            String surname,
            String index,
            Integer enrollmentYear,
            Integer studyYear,
            Double minAverageGrade,
            Double maxAverageGrade,
            Pageable pageable
    ) {
        return studentOnYearRepository.searchStudents(name, surname, index, enrollmentYear, studyYear, minAverageGrade, maxAverageGrade, pageable);
    }

    public StudentDetailsDto getStudentDetails(long studentId) {
        List<StudentOnYear> studentOnYears = studentOnYearRepository.findByStudent_Id(studentId);
        List<StudentOnYearDto> studentOnYearsDtos = new ArrayList<StudentOnYearDto>();
        for(StudentOnYear onYear : studentOnYears) {
            StudentOnYearDto dto = new StudentOnYearDto(onYear);
            studentOnYearsDtos.add(dto);
        }
        return null; 
    }

    @Transactional
    public List<StudentOnYear> enrollStudent(EnrollmentRequestDto dto) {
        if (dto.getYear() == 1) {

            User student = userRepository.findByUsername(dto.getStudentIndex())
                .orElseThrow(() -> new RuntimeException("Student with username '" + dto.getStudentIndex() + "' not found."));

            if (studentOnYearRepository.findByStudentIdAndYear(student.getId(), 1).isPresent()) {
                throw new RuntimeException("Student with username '" + dto.getStudentIndex() + "' is already enrolled in year 1.");
            }
            return createFirstYearEnrollment(dto, student);
        }
        
        else {
            Optional<StudentOnYear> previousEnrollmentOpt = studentOnYearRepository.findFirstByIndex(dto.getStudentIndex());
            if (previousEnrollmentOpt.isEmpty()) {
                throw new RuntimeException("Student with index '" + dto.getStudentIndex() + "' not found in any previous year.");
            }

            StudentOnYear previousEnrollment = previousEnrollmentOpt.get();
            User student = previousEnrollment.getStudent();

            List<StudentOnYear> newEnrollments = new ArrayList<>();
            int currentYear = Year.now().getValue();

            for (Long programId : dto.getStudyProgramIds()) {
                StudyProgram studyProgram = studyProgramRepository.findById(programId)
                    .orElseThrow(() -> new RuntimeException("Study program with ID '" + programId + "' not found."));

                if (studentOnYearRepository.findByStudentIdAndStudyProgramIdAndYear(student.getId(), programId, dto.getYear()).isPresent()) {
                    throw new RuntimeException("Student '" + dto.getStudentIndex() + "' is already enrolled in program '" + studyProgram.getName() + "' for year " + dto.getYear() + ".");
                }

                StudentOnYear newEnrollment = new StudentOnYear();
                newEnrollment.setStudent(student);
                newEnrollment.setStudyProgram(studyProgram);
                newEnrollment.setDateOfEnrollment(currentYear);
                newEnrollment.setYear(dto.getYear());
                newEnrollment.setIndex(previousEnrollment.getIndex());
                newEnrollment.setIndexNumber(previousEnrollment.getIndexNumber());
                newEnrollment.setAverageGrade(previousEnrollment.getAverageGrade());

                StudentOnYear savedEnrollment = studentOnYearRepository.save(newEnrollment);
                newEnrollments.add(savedEnrollment);

                List<CourseOnProgram> mandatoryCourses = courseOnProgramRepository.findByStudyProgramIdAndYearAndCourseMandatory(studyProgram.getId(), dto.getYear(), true);
                for (CourseOnProgram cop : mandatoryCourses) {
                    StudentCourse studentCourse = new StudentCourse();
                    studentCourse.setStudent(student);
                    studentCourse.setCourse(cop.getCourse());
                    studentCourse.setStatus(EnrollmentStatus.ENROLLED);
                    studentCourse.setGrade(null);
                    studentCourse.setPoints(0);
                    studentCourse.setNumberOfExamApplications(0);
                    studentCourseRepository.save(studentCourse);
                }
            }
            return newEnrollments;
        }
    }
    
    private List<StudentOnYear> createFirstYearEnrollment(EnrollmentRequestDto dto, User student) {
        List<StudentOnYear> newEnrollments = new ArrayList<>();
        int currentYear = Year.now().getValue();

        for (Long programId : dto.getStudyProgramIds()) {
            StudyProgram studyProgram = studyProgramRepository.findById(programId)
                .orElseThrow(() -> new RuntimeException("Study program with ID '" + programId + "' not found."));

            StudentOnYear newEnrollment = new StudentOnYear();
            newEnrollment.setStudent(student);
            newEnrollment.setStudyProgram(studyProgram);
            newEnrollment.setDateOfEnrollment(currentYear);
            newEnrollment.setYear(dto.getYear());

            Integer maxIndexNumber = studentOnYearRepository.findMaxIndexNumber();
            int newIndexNumber = (maxIndexNumber == null) ? 1 : maxIndexNumber + 1;
            newEnrollment.setIndexNumber(newIndexNumber);
            newEnrollment.setIndex(currentYear + "/" + newIndexNumber);
            newEnrollment.setAverageGrade(5.0);

            StudentOnYear savedEnrollment = studentOnYearRepository.save(newEnrollment);
            newEnrollments.add(savedEnrollment);

            List<CourseOnProgram> mandatoryCourses = courseOnProgramRepository.findByStudyProgramIdAndYearAndCourseMandatory(studyProgram.getId(), dto.getYear(), true);
            for (CourseOnProgram cop : mandatoryCourses) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(student);
                studentCourse.setCourse(cop.getCourse());
                studentCourse.setStatus(EnrollmentStatus.ENROLLED);
                studentCourse.setGrade(null);
                studentCourse.setPoints(0);
                studentCourse.setNumberOfExamApplications(0);
                studentCourseRepository.save(studentCourse);
            }
        }
        return newEnrollments;
    }
}
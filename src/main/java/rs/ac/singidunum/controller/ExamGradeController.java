package rs.ac.singidunum.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.ExamGradeDto;
import rs.ac.singidunum.model.Course;
import rs.ac.singidunum.model.ExamApplication;
import rs.ac.singidunum.model.ExamGrade;
import rs.ac.singidunum.model.ExamTerm;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.ExamApplicationStatus;
import rs.ac.singidunum.repository.ProfessorCourseRepository;
import rs.ac.singidunum.service.CourseService;
import rs.ac.singidunum.service.ExamApplicationService;
import rs.ac.singidunum.service.ExamGradeService;
import rs.ac.singidunum.service.ExamTermService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/exam-grades")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamGradeController {

	@Autowired
    private ExamGradeService examGradeService;

    @Autowired
    private ExamApplicationService examApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExamTermService examTermService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorCourseRepository professorCourseRepository;

    @GetMapping
    public List<ExamGradeDto> getAllGrades() {
        return examGradeService.getAllGrades()
                .stream()
                .map(ExamGradeDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/term/{termId}")
    public List<ExamGradeDto> getGradesByTerm(@PathVariable Long termId) {
        return examGradeService.getGradesByTermId(termId)
                .stream()
                .map(ExamGradeDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/course/{courseId}")
    public List<ExamGradeDto> getGradesByCourse(@PathVariable Long courseId) {
        return examGradeService.getGradesByCourseId(courseId)
                .stream()
                .map(ExamGradeDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/my-courses")
    public ResponseEntity<?> getGradesForMyCourses(Authentication authentication) {
        try {
            String username = authentication.getName();
            User professor = userService.getUserByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Professor not found"));

            List<ExamGradeDto> grades = examGradeService.getGradesByProfessorId(professor.getId())
                    .stream()
                    .map(ExamGradeDto::new)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(grades);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // NOVA METODA - Unesi ocenu preko applicationId
    @PostMapping("/grade-application/{applicationId}")
    public ResponseEntity<?> gradeApplication(
            @PathVariable Long applicationId,
            @RequestBody Map<String, Integer> request,
            Authentication authentication) {
        try {
            String username = authentication.getName();
            User professor = userService.getUserByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Professor not found"));

            // Pronađi prijavu
            ExamApplication application = examApplicationService.getApplicationById(applicationId)
                    .orElseThrow(() -> new RuntimeException("Application not found"));

            ExamTerm term = application.getExamTerm();
            Course course = application.getCourse();
            User student = application.getStudent();

            // Proveri da li je profesor na tom kursu
            boolean isProfessorOnCourse = professorCourseRepository
                    .existsByProfessorIdAndCourseId(professor.getId(), course.getId());

            if (!isProfessorOnCourse) {
                return ResponseEntity.badRequest()
                        .body("You are not authorized to enter grades for this course");
            }

            // Proveri rok od 15 dana
            long daysSinceExam = ChronoUnit.DAYS.between(
                    term.getExamDate().toLocalDate(),
                    LocalDate.now()
            );

            if (daysSinceExam < 0) {
                return ResponseEntity.badRequest()
                        .body("Cannot grade before the exam date");
            }

            if (daysSinceExam > 15) {
                return ResponseEntity.badRequest()
                        .body("Grade can only be entered within 15 days of the exam date. Days passed: " + daysSinceExam);
            }

            // Proveri da li već postoji ocena
            if (examGradeService.gradeExists(student.getId(), course.getId(), term.getId())) {
                return ResponseEntity.badRequest()
                        .body("Grade already exists for this student, course and exam term");
            }

            // Validacija ocene
            Integer gradeValue = request.get("grade");
            if (gradeValue == null || gradeValue < 5 || gradeValue > 10) {
                return ResponseEntity.badRequest().body("Grade must be between 5 and 10");
            }

            // Kreiraj ExamGrade
            ExamGrade grade = new ExamGrade();
            grade.setStudent(student);
            grade.setCourse(course);
            grade.setExamTerm(term);
            grade.setGrade(gradeValue);
            grade.setDateGraded(LocalDate.now());

            ExamGrade saved = examGradeService.saveGrade(grade);

            // Promeni status aplikacije na GRADED
            application.setStatus(ExamApplicationStatus.GRADED);
            examApplicationService.saveApplication(application);

            return ResponseEntity.ok(new ExamGradeDto(saved));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // STARA METODA - Ostavi je ako ti treba
    @PostMapping
    public ResponseEntity<?> addGrade(@RequestBody ExamGradeDto dto, Authentication authentication) {
        try {
            String username = authentication.getName();
            User professor = userService.getUserByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Professor not found"));

            boolean isProfessorOnCourse = professorCourseRepository
                    .existsByProfessorIdAndCourseId(professor.getId(), dto.getCourseId());

            if (!isProfessorOnCourse) {
                return ResponseEntity.badRequest()
                        .body("You are not authorized to enter grades for this course");
            }

            ExamTerm term = examTermService.getTermById(dto.getTermId())
                    .orElseThrow(() -> new RuntimeException("Exam term not found"));

            long daysSinceExam = ChronoUnit.DAYS.between(
                    term.getExamDate().toLocalDate(),
                    LocalDate.now()
            );

            if (daysSinceExam > 15) {
                return ResponseEntity.badRequest()
                        .body("Grade can only be entered within 15 days of the exam date. Days passed: " + daysSinceExam);
            }

            User student = userService.getUserById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            if (examGradeService.gradeExists(student.getId(), dto.getCourseId(), term.getId())) {
                return ResponseEntity.badRequest()
                        .body("Grade already exists for this student, course and exam term");
            }

            Course course = courseService.getCourseById(dto.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            ExamGrade grade = new ExamGrade();
            grade.setStudent(student);
            grade.setCourse(course);
            grade.setExamTerm(term);
            grade.setGrade(dto.getGrade());
            grade.setDateGraded(LocalDate.now());

            ExamGrade saved = examGradeService.saveGrade(grade);
            return ResponseEntity.ok(new ExamGradeDto(saved));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

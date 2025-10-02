package rs.ac.singidunum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import rs.ac.singidunum.dto.StudyProgramDto;
import rs.ac.singidunum.model.StudyProgram;
import rs.ac.singidunum.model.Faculty; 
import rs.ac.singidunum.model.User;    
import rs.ac.singidunum.repository.CourseOnProgramRepository;
import rs.ac.singidunum.repository.StudyProgramRepository;
import rs.ac.singidunum.repository.FacultyRepository;  
import rs.ac.singidunum.repository.UserRepository;     
import jakarta.persistence.EntityManager; // 🔑 KLJUČAN NOVI IMPORT


@Service
public class StudyProgramService {

    @Autowired
    private StudyProgramRepository studyProgramrepository;
    
    @Autowired
    private CourseOnProgramRepository courseOnProgramRepository;
    
    // Repozitorijumi za pronalaženje povezanih entiteta
    @Autowired
    private FacultyRepository facultyRepository; 
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EntityManager entityManager; // 🔑 KLJUČAN NOVI ZAVISNOST

// --- Metode koje su radile ---

    public List<StudyProgram> findAll() {
        return studyProgramrepository.findAll();
    }
    
    public List<StudyProgramDto> findAllAsDto() {
        return studyProgramrepository.findAll().stream()
                .map(StudyProgramDto::new)
                .collect(Collectors.toList());
    }

    public StudyProgram findOne(Long id) {
        return studyProgramrepository.findById(id).orElse(null);
    }

    @Transactional
    public StudyProgram save(StudyProgram studyProgram) {
        return studyProgramrepository.save(studyProgram);
    }
    
    @Transactional
    public void delete(Long id) {
        courseOnProgramRepository.deleteByStudyProgram_Id(id);
        studyProgramrepository.deleteById(id);
    }

    public List<StudyProgram> getAllByFacultyId(Long facultyId) {
        return studyProgramrepository.findByFaculty_IdOrderByNameAsc(facultyId);
    }
    
    
// --- Ispravljena Update Metoda ---

    /**
     * Ažurira postojeći StudyProgram entitet i koristi EntityManager.merge() 
     * da bi osigurao da Hibernate detektuje promene na relacijama (Faculty i Manager).
     */
    @Transactional
    public StudyProgramDto update(Long id, StudyProgramDto updatedDto) {
        
        // 1. Pronađi postojeći StudyProgram entitet
        StudyProgram program = studyProgramrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Study Program with ID " + id + " not found"));

        // 2. Ažuriranje prostih polja
        program.setName(updatedDto.getName());
        program.setDescription(updatedDto.getDescription());
        
        // 3. Ažuriranje povezanih entiteta
        
        // 3a. Ažuriranje Faculty
        // Proveravamo da li je ID poslat I da li se razlikuje od trenutnog ID-a
        if (updatedDto.getFacultyId() != null && (program.getFaculty() == null 
             || !program.getFaculty().getId().equals(updatedDto.getFacultyId()))) {
            
            Faculty faculty = facultyRepository.findById(updatedDto.getFacultyId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Faculty with ID " + updatedDto.getFacultyId() + " not found"));
            
            program.setFaculty(faculty); 
        }

        // 3b. Ažuriranje Manager-a
        // Proveravamo da li je ID poslat I da li se razlikuje od trenutnog ID-a
        if (updatedDto.getManagerId() != null && (program.getManager() == null 
             || !program.getManager().getId().equals(updatedDto.getManagerId()))) {
            
            User manager = userRepository.findById(updatedDto.getManagerId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Manager (User) with ID " + updatedDto.getManagerId() + " not found"));
            
            program.setManager(manager); 
        }

    
        StudyProgram updatedProgram = entityManager.merge(program);
        
        return new StudyProgramDto(updatedProgram);
    }
}
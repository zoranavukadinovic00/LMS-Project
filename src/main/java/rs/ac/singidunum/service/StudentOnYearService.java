package rs.ac.singidunum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.StudentDetailsDto;
import rs.ac.singidunum.dto.StudentOnYearDto;
import rs.ac.singidunum.model.StudentOnYear;
import rs.ac.singidunum.repository.StudentOnYearRepository;

@Service
public class StudentOnYearService {
	
	@Autowired
    private StudentOnYearRepository studentOnYearRepository;

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

}

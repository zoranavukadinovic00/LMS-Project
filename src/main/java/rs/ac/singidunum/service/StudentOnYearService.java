package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

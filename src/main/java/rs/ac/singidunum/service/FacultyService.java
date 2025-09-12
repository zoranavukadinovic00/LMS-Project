package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.FacultyDto;
import rs.ac.singidunum.model.Faculty;
import rs.ac.singidunum.repository.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    public Faculty findOne(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    public void delete(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    public boolean existsById(Long id) {
        if (id == null) {
            return false;
        }
        return facultyRepository.existsById(id);
    }
    
    public List<FacultyDto> findAllByUniversityId(Long universityId) {
        if (universityId == null) {
            return List.of(); 
        }
        
        return facultyRepository.findAllByUniversity_Id(universityId)
                .stream()
                .map(FacultyDto::new)
                .toList();
    }

    
    public List<Faculty> findAllByUniversityIdRaw(Long universityId) {
        if (universityId == null) {
            return List.of();
        }
        return facultyRepository.findAllByUniversity_Id(universityId);
    }
    
   
}

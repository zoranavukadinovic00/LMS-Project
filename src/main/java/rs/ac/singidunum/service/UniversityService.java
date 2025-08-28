package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.University;
import rs.ac.singidunum.repository.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
    private UniversityRepository universityRepository;

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public University findOne(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    public University save(University university) {
        return universityRepository.save(university);
    }

    public void delete(Long id) {
    	universityRepository.deleteById(id);
    }

    public void delete(University university) {
    	universityRepository.delete(university);
    }
}

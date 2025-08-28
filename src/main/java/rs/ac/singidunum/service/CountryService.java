package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Country;
import rs.ac.singidunum.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
    private CountryRepository contryRepository;

    public List<Country> findAll() {
        return contryRepository.findAll();
    }

    public Country findOne(Long id) {
        return contryRepository.findById(id).orElse(null);
    }

    public Country save(Country country) {
        return contryRepository.save(country);
    }

    public void delete(Long id) {
    	contryRepository.deleteById(id);
    }

    public void delete(Country country) {
    	contryRepository.delete(country);
    }
}

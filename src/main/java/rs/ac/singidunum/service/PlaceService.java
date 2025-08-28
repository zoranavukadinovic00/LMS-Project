package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Place;
import rs.ac.singidunum.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Place findOne(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public void delete(Long id) {
        placeRepository.deleteById(id);
    }

    public void delete(Place place) {
        placeRepository.delete(place);
    }
}

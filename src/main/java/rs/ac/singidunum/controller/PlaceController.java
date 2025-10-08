package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.model.Place;
import rs.ac.singidunum.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    // GET: /api/places
    @GetMapping
    public ResponseEntity<List<Place>> findAllPlaces() {
        List<Place> places = placeService.findAll();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    // GET: /api/places/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Place> findPlaceById(@PathVariable Long id) {
        Place place = placeService.findOne(id);
        if (place != null) {
            return new ResponseEntity<>(place, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST: /api/places
    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place savedPlace = placeService.save(place);
        return new ResponseEntity<>(savedPlace, HttpStatus.CREATED);
    }

    // PUT: /api/places/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
        if (placeService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        place.setId(id); // Pretpostavljamo da model ima metodu setId
        Place updatedPlace = placeService.save(place);
        return new ResponseEntity<>(updatedPlace, HttpStatus.OK);
    }

    // DELETE: /api/places/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        if (placeService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        placeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

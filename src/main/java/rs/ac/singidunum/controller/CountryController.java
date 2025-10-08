package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.model.Country;
import rs.ac.singidunum.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET: /api/countries
    @GetMapping
    public ResponseEntity<List<Country>> findAllCountries() {
        List<Country> countries = countryService.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    // GET: /api/countries/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id) {
        Country country = countryService.findOne(id);
        if (country != null) {
            return new ResponseEntity<>(country, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST: /api/countries
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    // PUT: /api/countries/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        // Logika provere da li entitet postoji je obično u servisu, ali možemo je imati i ovde.
        // Za jednostavni šifarnik, setujemo ID i šaljemo na save (koji radi i update).
        if (countryService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        country.setId(id); // Pretpostavljamo da model ima metodu setId
        Country updatedCountry = countryService.save(country);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    // DELETE: /api/countries/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        if (countryService.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

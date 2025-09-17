package rs.ac.singidunum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.dto.UniversityDto;
import rs.ac.singidunum.model.University;
import rs.ac.singidunum.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
@CrossOrigin(origins = "http://localhost:4200")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<UniversityDto>> getAllUniversities() {
        try {
            List<University> universities = universityService.findAll();
            List<UniversityDto> universityDtos = universities.stream()
                .map(UniversityDto::new)
                .toList();
            return ResponseEntity.ok(universityDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDto> getUniversityById(@PathVariable Long id) {
        try {
            University university = universityService.findOne(id);
            if (university == null) {
                return ResponseEntity.notFound().build();
            }
            UniversityDto universityDto = new UniversityDto(university);
            return ResponseEntity.ok(universityDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Dodat PUT endpoint za ažuriranje organizacije
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniversityDto> updateUniversity(@PathVariable Long id, @RequestBody UniversityDto universityDto) {
        try {
            University existingUniversity = universityService.findOne(id);
            if (existingUniversity == null) {
                return ResponseEntity.notFound().build();
            }

            existingUniversity.setName(universityDto.getName());
            existingUniversity.setContact(universityDto.getContact());
            existingUniversity.setDescription(universityDto.getDescription());
            existingUniversity.setDateOfEstablishment(universityDto.getDateOfEstablishment());

            // Napomena: Ažuriranje adrese i rektora zahteva dodatnu logiku i servise
            // U ovom primeru, preskačemo te promene da bi fokus bio na osnovnom ažuriranju
            // ako je potrebno, morali biste da nađete/kreirate novu adresu i korisnika
            // i da ih setujete na existingUniversity objekat

            University updatedUniversity = universityService.save(existingUniversity);
            return ResponseEntity.ok(new UniversityDto(updatedUniversity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Dodat DELETE endpoint za brisanje organizacije
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        try {
            universityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
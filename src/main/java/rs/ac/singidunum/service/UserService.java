package rs.ac.singidunum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.RegisterRequest;
import rs.ac.singidunum.dto.UserDto;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.model.enums.UserType;
import rs.ac.singidunum.repository.UserRepository;

@Service
public class UserService { 
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
    
    // IZMENA: Logika za određivanje UserType-a
    public User register(RegisterRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            return null;
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        
        // KLJUČNA IZMENA: Ako je Admin poslao tip, koristi ga; inače postavi STUDENT.
        if (req.getType() != null) {
            user.setType(req.getType()); 
        } else {
            user.setType(UserType.STUDENT);
        }

        user.setEmail(req.getEmail());
        user.setJmbg(req.getJmbg());
        user.setName(req.getName());
        user.setSurname(req.getSurname());
        
        // Biography se preuzima direktno, što je OK jer smo ga u modelu učinili opcionim
        user.setBiography(req.getBiography()); 

        userRepository.save(user);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    
    public User update(UserDto dto) {
        if (dto == null || dto.getId() == null) {
            return null;
        }
        
        User user = userRepository.findById(dto.getId()).orElse(null);
        if(user == null) {
            return null;
        }
        
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setJmbg(dto.getJmbg());
        user.setName(dto.getName());     
        user.setSurname(dto.getSurname());  
        user.setBiography(dto.getBiography());

        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

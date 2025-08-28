package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.RegisterRequest;
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
    
    public User register(RegisterRequest req) {
    	if (userRepository.existsByUsername(req.getUsername())) {
            return null;
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setType(UserType.STUDENT);
        user.setEmail(req.getEmail());
        user.setJmbg(req.getJmbg());
        user.setName(req.getName());
        user.setSurname(req.getSurname());
        user.setBiography(req.getBiography());

        userRepository.save(user);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}

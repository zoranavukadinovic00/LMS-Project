package rs.ac.singidunum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.dto.AuthResponse;
import rs.ac.singidunum.dto.LoginRequest;
import rs.ac.singidunum.dto.RegisterRequest;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.repository.UserRepository;
import rs.ac.singidunum.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    // Logika za registraciju (premeštena iz UserService)
    public User register(RegisterRequest req) {
        // Provera da li korisnik već postoji
        if (userRepository.existsByUsername(req.getUsername())) {
            // Vraćamo null ako korisnik već postoji
            return null; 
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setType(req.getType()); // Postavlja tip korisnika (STUDENT, ADMIN, STAFF, PROFESSOR)
        user.setEmail(req.getEmail());
        user.setJmbg(req.getJmbg());
        user.setName(req.getName());
        user.setSurname(req.getSurname());
        user.setBiography(req.getBiography());

        return userRepository.save(user);
    }

    // Logika za prijavu (login)
    public AuthResponse login(LoginRequest req) {
        // Pokušaj autentifikacije pomoću AuthenticationManager-a
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )
        );

        // Postavljanje autentifikovanog objekta u Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Pronalazak korisnika (potreban za generisanje tokena i detalja)
        User user = userRepository.findByUsername(req.getUsername()).orElseThrow();

        // Generisanje JWT tokena
        String token = jwtService.generateToken(user);
        
        // Vraćanje response objekta
        return new AuthResponse(token, user.getType().toString());
    }

    // Provera da li korisničko ime postoji
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}

package rs.ac.singidunum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rs.ac.singidunum.dto.AuthResponse;
import rs.ac.singidunum.dto.LoginRequest;
import rs.ac.singidunum.dto.RegisterRequest;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.security.AppUserDetailsService;
import rs.ac.singidunum.security.JwtService;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthenticationManager authManager;
	private final UserService userService;
	private final JwtService jwt;
	private final AppUserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authManager, UserService userService, JwtService jwt, AppUserDetailsService userDetailsService) {
		this.authManager = authManager;
		this.userService = userService;
		this.jwt = jwt;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        
    	User user = userService.register(req);
    	if(user == null) {
    		return ResponseEntity
                    .badRequest()
                    .body("Username already exists");
    	}
    	String token = jwt.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getType().toString()));
    }

	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
	    try {
	        Authentication auth = authManager.authenticate(
	                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
	        );

	        User user = userService.findByUsername(req.getUsername());
	        

	        String token = jwt.generateToken(user);
	        return ResponseEntity.ok(new AuthResponse(token, user.getType().toString()));

	    } catch (org.springframework.security.core.AuthenticationException ex) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
	}
}

package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rs.ac.singidunum.dto.UserDto;
import rs.ac.singidunum.model.User;
import rs.ac.singidunum.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
		User user = userService.update(dto);
		if (user == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		UserDto returnDto = new UserDto(user);
		return new ResponseEntity<>(returnDto, HttpStatus.OK);
	}

	@GetMapping("/my-profile")
	public ResponseEntity<UserDto> myProfile(@AuthenticationPrincipal UserDetails user) {

		String username = user.getUsername();
		User foundUser = userService.findByUsername(username);
		
		UserDto dto = new UserDto(foundUser);
		

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}

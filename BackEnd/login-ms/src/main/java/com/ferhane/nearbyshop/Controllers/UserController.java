package com.ferhane.nearbyshop.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferhane.nearbyshop.Entities.Role;
import com.ferhane.nearbyshop.Entities.RoleName;
import com.ferhane.nearbyshop.Entities.User;
import com.ferhane.nearbyshop.JWT.JwtProvider;
import com.ferhane.nearbyshop.Loginrequest.LoginForm;
import com.ferhane.nearbyshop.Loginrequest.SignUpForm;
import com.ferhane.nearbyshop.Repository.RoleRepository;
import com.ferhane.nearbyshop.Repository.UserRepository;
import com.ferhane.nearbyshop.loginResponse.JwtResponse;
import com.ferhane.nearbyshop.loginResponse.ResponseMessage;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@GetMapping("/Users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		Random rand= new Random();
		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),rand.nextInt(50));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
       
		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: admin Role not find."));
				roles.add(adminRole);

				break;
			
			default:
				Role userRole = roleRepository.findByName(RoleName.USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: user Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("signing up successfully!"), HttpStatus.OK);
	}
}
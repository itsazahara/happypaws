package com.daw.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.services.AuthService;
import com.daw.web.controllers.models.AuthResponse;
import com.daw.web.controllers.models.AuthenticationAdminRequest;
import com.daw.web.controllers.models.AuthenticationRequest;
import com.daw.web.controllers.models.RegisterAdminRequest;
import com.daw.web.controllers.models.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterAdminRequest request){
		return ResponseEntity.ok(authService.registerAdmin(request));
	}
	
	@PostMapping("/authenticateAdmin")
	public ResponseEntity<AuthResponse> authenticateAdmin(@RequestBody AuthenticationAdminRequest request){
		return ResponseEntity.ok(authService.authenticateAdmin(request));
	}

}

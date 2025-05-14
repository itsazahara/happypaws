package com.daw.services;

import com.daw.web.controllers.models.AuthResponse;
import com.daw.web.controllers.models.AuthenticationAdminRequest;
import com.daw.web.controllers.models.AuthenticationRequest;
import com.daw.web.controllers.models.RegisterAdminRequest;
import com.daw.web.controllers.models.RegisterRequest;

public interface AuthService {
	
	AuthResponse register (RegisterRequest request);
	
	AuthResponse authenticate (AuthenticationRequest request);
	
	AuthResponse registerAdmin (RegisterAdminRequest request);
	
	AuthResponse authenticateAdmin (AuthenticationAdminRequest request);

}

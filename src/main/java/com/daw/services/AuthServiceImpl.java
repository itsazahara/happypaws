package com.daw.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daw.config.jwtService;
import com.daw.persistence.entities.Administrador;
import com.daw.persistence.entities.Cliente;
import com.daw.persistence.entities.enumerados.Rol;
import com.daw.persistence.repositories.AdministradorRepository;
import com.daw.persistence.repositories.ClienteRepository;
import com.daw.web.controllers.models.AuthResponse;
import com.daw.web.controllers.models.AuthenticationAdminRequest;
import com.daw.web.controllers.models.AuthenticationRequest;
import com.daw.web.controllers.models.RegisterAdminRequest;
import com.daw.web.controllers.models.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final ClienteRepository clienteRepository;
	private final jwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final AdministradorRepository administradorRepository;

	@Override
	public AuthResponse register(RegisterRequest request) {
		Cliente cliente = Cliente.builder().nombre(request.getNombre()).apellidos(request.getApellidos())
				.usuario(request.getUsuario()).contrasenia(passwordEncoder.encode(request.getContrasenia()))
				.email(request.getEmail()).direccion(request.getDireccion()).edad(request.getEdad())
				.telefono(request.getTelefono()).ocupacionLaboral(request.getOcupacionLaboral())
				.tipoVivienda(request.getTipoVivienda()).otrasMascotas(request.getOtrasMascotas())
				.experienciaMascotas(request.getExperienciaMascotas()).observaciones(request.getObservaciones())
				.imagen(request.getImagen()).rol(Rol.USUARIO).build();
		clienteRepository.save(cliente);
		var jwtToken = jwtService.generateToken(cliente);
		return AuthResponse.builder().token(jwtToken).build();
	}

	@Override
	public AuthResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasenia()));
		Cliente cliente = clienteRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(cliente);
		return AuthResponse.builder().token(jwtToken).build();
	}

	@Override
	public AuthResponse registerAdmin(RegisterAdminRequest request) {
		Administrador admin = Administrador.builder().nombre(request.getNombre()).apellidos(request.getApellidos())
				.usuario(request.getUsuario()).contrasenia(passwordEncoder.encode(request.getContrasenia()))
				.email(request.getEmail()).telefono(request.getTelefono()).imagen(request.getImagen())
				.rol(Rol.ADMINISTRADOR).build();
		administradorRepository.save(admin);
		var jwtToken = jwtService.generateToken(admin);
		return AuthResponse.builder().token(jwtToken).build();
	}

	@Override
	public AuthResponse authenticateAdmin(AuthenticationAdminRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasenia()));
		Administrador admin = administradorRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(admin);
		return AuthResponse.builder().token(jwtToken).build();
	}

}

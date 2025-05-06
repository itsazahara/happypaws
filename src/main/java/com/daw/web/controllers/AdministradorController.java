package com.daw.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Administrador;
import com.daw.services.AdministradorService;
import com.daw.services.dtos.AdministradorDTO;
import com.daw.services.mappers.AdministradorMapper;

@RestController
@RequestMapping("/administradores")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@GetMapping
	public ResponseEntity<List<AdministradorDTO>> administradores() {
		List<Administrador> administradores = this.administradorService.findAll();
		List<AdministradorDTO> administradoresDTO = new ArrayList<>();
		for (Administrador administrador : administradores) {
			administradoresDTO.add(AdministradorMapper.toDto(administrador));
		}
		return ResponseEntity.ok(administradoresDTO);
	}

	@GetMapping("/{idAdministrador}")
	public ResponseEntity<AdministradorDTO> cliente(@PathVariable int idAdministrador) {
		Optional<Administrador> administrador = this.administradorService.findById(idAdministrador);
		if (administrador.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(AdministradorMapper.toDto(administrador.get()));
	}

	@PostMapping
	public ResponseEntity<AdministradorDTO> create(@RequestBody Administrador administrador) {
		Administrador savedAdministrador = administradorService.create(administrador);
		AdministradorDTO administradorDTO = AdministradorMapper.toDto(savedAdministrador);
		return new ResponseEntity<>(administradorDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idAdministrador}")
	public ResponseEntity<AdministradorDTO> update(@PathVariable int idAdministrador,
			@RequestBody AdministradorDTO administradorDTO) {
		if (idAdministrador != administradorDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!administradorService.existsAdministrador(idAdministrador)) {
			return ResponseEntity.notFound().build();
		}

		Administrador administrador = AdministradorMapper.toEntity(administradorDTO);
		Administrador updatedAdministrador = administradorService.save(administrador);
		AdministradorDTO responseDTO = AdministradorMapper.toDto(updatedAdministrador);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idAdministrador}")
	public ResponseEntity<AdministradorDTO> delete(@PathVariable int idAdministrador) {
		AdministradorDTO administradorEliminado = administradorService.delete(idAdministrador);

		if (administradorEliminado != null) {
			return ResponseEntity.ok(administradorEliminado);
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Administrador loginRequest) {
	    String email = loginRequest.getEmail();
	    String contrasenia = loginRequest.getContrasenia();
	    String usuario = loginRequest.getUsuario();

	    Optional<Administrador> administrador = Optional.empty();

	    if (email != null && !email.isEmpty()) {
	        administrador = administradorService.findByEmail(email);
	    }

	    if ((!administrador.isPresent()) && usuario != null && !usuario.isEmpty()) {
	        administrador = administradorService.findByUsuario(usuario);
	    }

	    if (administrador.isPresent() && administrador.get().getContrasenia().equals(contrasenia)) {
	        return ResponseEntity.ok(AdministradorMapper.toDto(administrador.get()));
	    }

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	}

}

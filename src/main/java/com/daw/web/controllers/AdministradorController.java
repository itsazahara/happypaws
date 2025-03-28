package com.daw.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;

	@GetMapping
	public ResponseEntity<List<Administrador>> list() {
		return ResponseEntity.ok(this.administradorService.findAll());
	}

	@GetMapping("/{idAdministrador}")
	public ResponseEntity<Administrador> findById(@PathVariable int idAdministrador) {
		Optional<Administrador> administrador = this.administradorService.findById(idAdministrador);
		if (administrador.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(administrador.get());
	}

	@PostMapping
	public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
		return new ResponseEntity<Administrador>(this.administradorService.create(administrador), HttpStatus.CREATED);
	}

	@PutMapping("/{idAdministrador}")
	public ResponseEntity<Administrador> update(@PathVariable int idAdministrador,
			@RequestBody Administrador administrador) {
		if (idAdministrador != administrador.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.administradorService.existsAdministrador(idAdministrador)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.administradorService.save(administrador));
	}

	@DeleteMapping("/{idAdministrador}")
	public ResponseEntity<Administrador> delete(@PathVariable int idAdministrador) {
		if (this.administradorService.delete(idAdministrador)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}

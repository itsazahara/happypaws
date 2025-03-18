package com.daw.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.daw.persistence.entities.Servicio;
import com.daw.services.ServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@GetMapping
	public ResponseEntity<List<Servicio>> list() {
		return ResponseEntity.ok(this.servicioService.findAll());
	}

	@GetMapping("/{idServicio}")
	public ResponseEntity<Servicio> findById(@PathVariable int idServicio) {
		Optional<Servicio> servicio = this.servicioService.findById(idServicio);
		if (servicio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(servicio.get());
	}

	@PostMapping
	public ResponseEntity<Servicio> create(@RequestBody Servicio servicio) {
		return new ResponseEntity<Servicio>(this.servicioService.create(servicio), HttpStatus.CREATED);
	}

	@PutMapping("/{idServicio}")
	public ResponseEntity<Servicio> update(@PathVariable int idServicio, @RequestBody Servicio servicio) {
		if (idServicio != servicio.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.servicioService.existsServicio(idServicio)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.servicioService.save(servicio));
	}

	@DeleteMapping("/{idServicio}")
	public ResponseEntity<Servicio> delete(@PathVariable int idServicio) {
		if (this.servicioService.delete(idServicio)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}

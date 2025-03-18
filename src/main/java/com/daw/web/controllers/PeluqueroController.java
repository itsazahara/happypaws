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

import com.daw.persistence.entities.Peluquero;
import com.daw.services.PeluqueroService;

@RestController
@RequestMapping("/peluqueros")
public class PeluqueroController {

	@Autowired
	private PeluqueroService peluqueroService;

	@GetMapping
	public ResponseEntity<List<Peluquero>> list() {
		return ResponseEntity.ok(this.peluqueroService.findAll());
	}

	@GetMapping("/{idPeluquero}")
	public ResponseEntity<Peluquero> findById(@PathVariable int idPeluquero) {
		Optional<Peluquero> peluquero = this.peluqueroService.findById(idPeluquero);
		if (peluquero.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(peluquero.get());
	}

	@PostMapping
	public ResponseEntity<Peluquero> create(@RequestBody Peluquero peluquero) {
		return new ResponseEntity<Peluquero>(this.peluqueroService.create(peluquero), HttpStatus.CREATED);
	}

	@PutMapping("/{idPeluquero}")
	public ResponseEntity<Peluquero> update(@PathVariable int idPeluquero, @RequestBody Peluquero peluquero) {
		if (idPeluquero != peluquero.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.peluqueroService.existsPeluquero(idPeluquero)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.peluqueroService.save(peluquero));
	}

	@DeleteMapping("/{idPeluquero}")
	public ResponseEntity<Peluquero> delete(@PathVariable int idPeluquero) {
		if (this.peluqueroService.delete(idPeluquero)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}

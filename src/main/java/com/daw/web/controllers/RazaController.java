package com.daw.web.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Raza;
import com.daw.services.RazaService;

@RestController
@RequestMapping("/razas")
@CrossOrigin(origins = "http://localhost:4200")
public class RazaController {

	@Autowired
	private RazaService razaService;

	@GetMapping
	public ResponseEntity<List<Raza>> list(){
		return ResponseEntity.ok(this.razaService.findAll());
	}

	@GetMapping("/{idRaza}")
	public ResponseEntity<Raza> findById(@PathVariable int idRaza) {
		Optional<Raza> raza = this.razaService.findById(idRaza);
		if(raza.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(raza.get());
	}

	@PostMapping
	public ResponseEntity<Raza> create(@RequestBody Raza raza){
		return new ResponseEntity<Raza>(this.razaService.create(raza), HttpStatus.CREATED);
	}

	@PutMapping("/{idRaza}")
	public ResponseEntity<Raza> update(@PathVariable int idRaza, @RequestBody Raza raza){
		if(idRaza != raza.getId()) {
			return ResponseEntity.badRequest().build();
		}
		else if(!this.razaService.existsRaza(idRaza)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.razaService.save(raza));
	}
	
	@DeleteMapping("/{idRaza}")
	public ResponseEntity<Raza> delete(@PathVariable int idRaza){
		if(this.razaService.delete(idRaza)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscador")
	public ResponseEntity<List<Raza>> findByNombre(@RequestParam String nombre) {
		return ResponseEntity.ok(this.razaService.getByNombre(nombre));
	}

}

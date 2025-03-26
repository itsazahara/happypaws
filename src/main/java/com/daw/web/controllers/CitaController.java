package com.daw.web.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.daw.persistence.entities.Cita;
import com.daw.persistence.entities.enumerados.Estado;
import com.daw.services.CitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;

	@GetMapping
	public ResponseEntity<List<Cita>> list() {
		return ResponseEntity.ok(this.citaService.findAll());
	}

	@GetMapping("/{idCita}")
	public ResponseEntity<Cita> findById(@PathVariable int idCita) {
		Optional<Cita> cita = this.citaService.findById(idCita);
		if (cita.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cita.get());
	}

	@PostMapping
	public ResponseEntity<Cita> create(@RequestBody Cita cita) {
		return new ResponseEntity<Cita>(this.citaService.create(cita), HttpStatus.CREATED);
	}

	@PutMapping("/{idCita}")
	public ResponseEntity<Cita> update(@PathVariable int idCita, @RequestBody Cita cita) {
		if (idCita != cita.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.citaService.existsCita(idCita)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.citaService.save(cita));
	}

	@DeleteMapping("/{idCita}")
	public ResponseEntity<Cita> delete(@PathVariable int idCita) {
		if (this.citaService.delete(idCita)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<List<Cita>> obtenerCitasPorCliente(@PathVariable int idCliente) {
		return ResponseEntity.ok(citaService.obtenerCitasPorCliente(idCliente));
	}

	@GetMapping("/fecha/{fecha}")
	public ResponseEntity<List<Cita>> obtenerCitasPorFecha(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		return ResponseEntity.ok(citaService.obtenerCitasPorFecha(fecha));
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Cita>> obtenerCitasPorEstado(@PathVariable Estado estado) {
		return ResponseEntity.ok(citaService.obtenerCitasPorEstado(estado));
	}

	@PutMapping("/{id}/confirmar")
	public ResponseEntity<Cita> confirmarCita(@PathVariable int id) {
		return ResponseEntity.ok(citaService.confirmarCita(id));
	}

	@PutMapping("/{id}/cancelar")
	public ResponseEntity<Cita> cancelarCita(@PathVariable int id) {
		return ResponseEntity.ok(citaService.cancelarCita(id));
	}

}

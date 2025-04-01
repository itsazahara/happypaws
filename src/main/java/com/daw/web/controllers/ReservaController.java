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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Reserva;
import com.daw.persistence.entities.enumerados.Estado;
import com.daw.services.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public ResponseEntity<List<Reserva>> list() {
		return ResponseEntity.ok(this.reservaService.findAll());
	}

	@GetMapping("/{idReserva}")
	public ResponseEntity<Reserva> findById(@PathVariable int idReserva) {
		Optional<Reserva> reserva = this.reservaService.findById(idReserva);
		if (reserva.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(reserva.get());
	}

	@PostMapping
	public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
		return new ResponseEntity<Reserva>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}

	@PutMapping("/{idReserva}")
	public ResponseEntity<Reserva> update(@PathVariable int idReserva, @RequestBody Reserva reserva) {
		if (idReserva != reserva.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.reservaService.existsReserva(idReserva)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.reservaService.save(reserva));
	}

	@DeleteMapping("/{idReserva}")
	public ResponseEntity<Reserva> delete(@PathVariable int idReserva) {
		if (this.reservaService.delete(idReserva)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/estado/{estado}")
    public List<Reserva> getReservasPorEstado(@PathVariable Estado estado) {
        return reservaService.buscarPorEstado(estado);
    }
	
	@GetMapping("/ordenarPorFecha")
	public List<Reserva> getReservasOrdenadas(@RequestParam(defaultValue = "desc") String orden) {
        return reservaService.obtenerReservasOrdenadas(orden);
    }
	
	@GetMapping("/cliente/{clienteId}")
    public List<Reserva> getReservasPorCliente(@PathVariable Integer clienteId) {
        return reservaService.buscarPorCliente(clienteId);
    }
	
	@PutMapping("/{id}/estado")
    public Reserva actualizarEstadoReserva(@PathVariable Integer id, @RequestParam Estado nuevoEstado) {
        return reservaService.actualizarEstado(id, nuevoEstado);
    }

}

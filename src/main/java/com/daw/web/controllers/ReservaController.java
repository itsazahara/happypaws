package com.daw.web.controllers;

import java.util.ArrayList;
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
import com.daw.services.dtos.ReservaDTO;
import com.daw.services.dtos.ReservaRequestDTO;
import com.daw.services.mappers.ReservaMapper;
import com.daw.services.mappers.ReservaRequestMapper;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public ResponseEntity<List<ReservaDTO>> reservas() {
		List<Reserva> reservas = this.reservaService.findAll();
		List<ReservaDTO> reservasDTO = new ArrayList<>();
		for (Reserva reserva : reservas) {
			reservasDTO.add(ReservaMapper.toDTO(reserva, false));
		}
		return ResponseEntity.ok(reservasDTO);
	}

	@GetMapping("/{idReserva}")
	public ResponseEntity<ReservaDTO> reserva(@PathVariable int idReserva) {
		Optional<Reserva> reserva = this.reservaService.findById(idReserva);
		if (reserva.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(ReservaMapper.toDTO(reserva.get(), false));
	}

	@PostMapping
	public ResponseEntity<Reserva> create(@RequestBody ReservaRequestDTO reservaRequestDTO) {
		try {
			Reserva nuevaReserva = reservaService.create(reservaRequestDTO);

			return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{idReserva}")
    public ResponseEntity<Reserva> update(@PathVariable Integer idReserva, @RequestBody ReservaRequestDTO reservaRequestDTO) {
        if (!idReserva.equals(reservaRequestDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Reserva> reservaOptional = reservaService.findById(idReserva);
        
        if (!reservaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        try {
        	Reserva reserva = ReservaRequestMapper.toEntity(reservaRequestDTO);
        	reserva.setId(idReserva);
            Reserva updatedReserva = reservaService.save(reserva);
            return ResponseEntity.ok(updatedReserva);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@DeleteMapping("/{idReserva}")
	public ResponseEntity<ReservaDTO> delete(@PathVariable int idReserva) {
		ReservaDTO reservaEliminado = reservaService.delete(idReserva);

		if (reservaEliminado != null) {
			return ResponseEntity.ok(reservaEliminado);
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/estado/{estado}")
    public List<ReservaDTO> getReservasPorEstado(@PathVariable Estado estado) {
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

	/* FALTA EL TESTING DE ESTE ENDPOINT */
	@PutMapping("/{id}/estado")
	public ReservaDTO actualizarEstadoReserva(@PathVariable Integer id, @RequestParam Estado nuevoEstado) {
		return reservaService.actualizarEstado(id, nuevoEstado);
	}

	/* FALTA COMPROBAR EL ENDPOINT DE ACTUALIZAR LA DISPONIBILIDAD */

}

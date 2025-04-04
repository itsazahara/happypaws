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
import com.daw.services.mappers.ReservaMapper;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping
	public ResponseEntity<List<ReservaDTO>> reservas(){
		List<Reserva> reservas = this.reservaService.findAll();
		List<ReservaDTO> reservasDTO = new ArrayList<>();
		for(Reserva reserva : reservas) {
			reservasDTO.add(ReservaMapper.toDTO(reserva, false));
		}
		return ResponseEntity.ok(reservasDTO);
	}
	
	@GetMapping("/{idReserva}")
	public ResponseEntity<ReservaDTO> reserva(@PathVariable int idReserva) {
		Optional<Reserva> reserva = this.reservaService.findById(idReserva);
		if(reserva.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ReservaMapper.toDTO(reserva.get(), false));
	}

	@PostMapping
    public ResponseEntity<ReservaDTO> create(@RequestBody Reserva reserva) {
		Reserva savedReserva = reservaService.create(reserva);
		ReservaDTO reservaDTO = ReservaMapper.toDTO(savedReserva, false);
        return new ResponseEntity<>(reservaDTO, HttpStatus.CREATED);
    }

	@PutMapping("/{idReserva}")
    public ResponseEntity<ReservaDTO> update(@PathVariable int idReserva, @RequestBody ReservaDTO reservaDTO) {
        if (idReserva != reservaDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }
        if (!reservaService.existsReserva(idReserva)) {
            return ResponseEntity.notFound().build();
        }

        Reserva reserva = ReservaMapper.toEntity(reservaDTO);
        Reserva updatedReserva = reservaService.save(reserva);
        ReservaDTO responseDTO = ReservaMapper.toDTO(updatedReserva, false);

        return ResponseEntity.ok(responseDTO);
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
	
	/* FALTA EL TESTING DE ESTE ENDPOINT */
	@PutMapping("/{id}/estado")
    public Reserva actualizarEstadoReserva(@PathVariable Integer id, @RequestParam Estado nuevoEstado) {
        return reservaService.actualizarEstado(id, nuevoEstado);
    }
	
	/* FALTA COMPROBAR EL ENDPOINT DE ACTUALIZAR LA DISPONIBILIDAD */

}

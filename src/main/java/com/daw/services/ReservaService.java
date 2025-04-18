package com.daw.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Reserva;
import com.daw.persistence.entities.enumerados.Estado;
import com.daw.persistence.repositories.ReservaRepository;
import com.daw.services.dtos.ReservaDTO;
import com.daw.services.dtos.ReservaRequestDTO;
import com.daw.services.mappers.ReservaMapper;

import jakarta.transaction.Transactional;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	public List<Reserva> findAll() {
		return this.reservaRepository.findAll();
	}

	public boolean existsReserva(int idReserva) {
		return this.reservaRepository.existsById(idReserva);
	}

	public Optional<Reserva> findById(int idReserva) {
		return this.reservaRepository.findById(idReserva);
	}

	public Reserva create(ReservaRequestDTO dto) {
		Reserva reserva = new Reserva();

		reserva.setIdMascota(dto.getIdMascota());
		reserva.setIdCliente(dto.getIdCliente());
		reserva.setIdAdministrador(dto.getIdAdministrador());

		reserva.setEstado(dto.getEstado() != null ? dto.getEstado() : Estado.PENDIENTE);
		reserva.setObservaciones(dto.getObservaciones());

		return reservaRepository.save(reserva);
	}

	public Reserva save(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	public ReservaDTO delete(int idReserva) {
		Optional<Reserva> reservaOptional = reservaRepository.findById(idReserva);

		if (reservaOptional.isPresent()) {
			Reserva reserva = reservaOptional.get();
			reservaRepository.delete(reserva);
			return ReservaMapper.toDTO(reserva, false);
		}

		return null;
	}

	public List<ReservaDTO> buscarPorEstado(Estado estado) {
		List<Reserva> reservas = reservaRepository.findByEstado(estado);
		return reservas.stream().map(reserva -> ReservaMapper.toDTO(reserva, true)).collect(Collectors.toList());
	}

	public List<Reserva> obtenerReservasOrdenadas(String orden) {
		if ("asc".equalsIgnoreCase(orden)) {
			return reservaRepository.findAllByOrderByFechaSolicitudAsc();
		} else {
			return reservaRepository.findAllByOrderByFechaSolicitudDesc();
		}
	}

	public List<Reserva> buscarPorCliente(Integer clienteId) {
		return reservaRepository.findByClienteId(clienteId);
	}

	@Transactional
	public ReservaDTO actualizarEstado(Integer id, Estado nuevoEstado) {
		Optional<Reserva> reservaOptional = reservaRepository.findById(id);
		if (reservaOptional.isPresent()) {
			Reserva reserva = reservaOptional.get();
			reserva.setEstado(nuevoEstado);
			Reserva actualizada = reservaRepository.save(reserva);

			return ReservaMapper.toDTO(actualizada, true);
		} else {
			throw new RuntimeException("Reserva no encontrada con ID: " + id);
		}
	}

}

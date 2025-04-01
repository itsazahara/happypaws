package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Reserva;
import com.daw.persistence.entities.enumerados.Estado;
import com.daw.persistence.repositories.ReservaRepository;

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

	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	public Reserva save(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}

	public boolean delete(int idReserva) {
		boolean result = false;

		if (this.reservaRepository.existsById(idReserva)) {
			this.reservaRepository.deleteById(idReserva);
			result = true;
		}

		return result;
	}
	
	public List<Reserva> buscarPorEstado(Estado estado) {
        return reservaRepository.findByEstado(estado);
    }
	
	public List<Reserva> obtenerReservasOrdenadas(String orden) {
        if ("asc".equalsIgnoreCase(orden)) {
            return reservaRepository.findAllByOrderByFechaSolicitudAsc();
        } else {
            return reservaRepository.findAllByOrderByFechaSolicitudDesc();
        }
    }

}

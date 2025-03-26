package com.daw.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Cita;
import com.daw.persistence.entities.enumerados.Estado;
import com.daw.persistence.repositories.CitaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	public List<Cita> findAll() {
		return this.citaRepository.findAll();
	}

	public boolean existsCita(int idCita) {
		return this.citaRepository.existsById(idCita);
	}

	public Optional<Cita> findById(int idCita) {
		return this.citaRepository.findById(idCita);
	}

	public Cita create(Cita cita) {
		return this.citaRepository.save(cita);
	}

	public Cita save(Cita cita) {
		return this.citaRepository.save(cita);
	}

	public boolean delete(int idCita) {
		boolean result = false;

		if (this.citaRepository.existsById(idCita)) {
			this.citaRepository.deleteById(idCita);
			result = true;
		}

		return result;
	}

	public List<Cita> obtenerCitasPorCliente(int idCliente) {
		return citaRepository.findByClienteId(idCliente);
	}

	public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
		return citaRepository.findByFecha(fecha);
	}

	public List<Cita> obtenerCitasPorEstado(Estado estado) {
		return citaRepository.findByEstado(estado);
	}

	public Cita confirmarCita(int id) {
		Cita cita = citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));

		cita.setEstado(Estado.CONFIRMADA);
		return citaRepository.save(cita);
	}

	public Cita cancelarCita(int id) {
		Cita cita = citaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
		
		cita.setEstado(Estado.CANCELADA);
		return citaRepository.save(cita);
	}

}

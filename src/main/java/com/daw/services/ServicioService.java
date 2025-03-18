package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Servicio;
import com.daw.persistence.repositories.ServicioRepository;

@Service
public class ServicioService {

	@Autowired
	private ServicioRepository servicioRepository;

	public List<Servicio> findAll() {
		return this.servicioRepository.findAll();
	}

	public boolean existsServicio(int idServicio) {
		return this.servicioRepository.existsById(idServicio);
	}

	public Optional<Servicio> findById(int idServicio) {
		return this.servicioRepository.findById(idServicio);
	}

	public Servicio create(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}

	public Servicio save(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}

	public boolean delete(int idServicio) {
		boolean result = false;

		if (this.servicioRepository.existsById(idServicio)) {
			this.servicioRepository.deleteById(idServicio);
			result = true;
		}

		return result;
	}

}

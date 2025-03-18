package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Peluquero;
import com.daw.persistence.repositories.PeluqueroRepository;

@Service
public class PeluqueroService {

	@Autowired
	private PeluqueroRepository peluqueroRepository;

	public List<Peluquero> findAll() {
		return this.peluqueroRepository.findAll();
	}

	public boolean existsPeluquero(int idPeluquero) {
		return this.peluqueroRepository.existsById(idPeluquero);
	}

	public Optional<Peluquero> findById(int idPeluquero) {
		return this.peluqueroRepository.findById(idPeluquero);
	}

	public Peluquero create(Peluquero peluquero) {
		return this.peluqueroRepository.save(peluquero);
	}

	public Peluquero save(Peluquero peluquero) {
		return this.peluqueroRepository.save(peluquero);
	}

	public boolean delete(int idPeluquero) {
		boolean result = false;

		if (this.peluqueroRepository.existsById(idPeluquero)) {
			this.peluqueroRepository.deleteById(idPeluquero);
			result = true;
		}

		return result;
	}

}

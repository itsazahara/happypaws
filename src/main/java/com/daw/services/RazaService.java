package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Raza;
import com.daw.persistence.repositories.RazaRepository;

@Service
public class RazaService {

	@Autowired
	private RazaRepository razaRepository;

	public List<Raza> findAll(){
		return this.razaRepository.findAll();
	}

	public boolean existsRaza(int idRaza) {
		return this.razaRepository.existsById(idRaza);
	}

	public Optional<Raza> findById(int idRaza) {
		return this.razaRepository.findById(idRaza);
	}

	public Raza create(Raza raza) {
		return this.razaRepository.save(raza);
	}

	public Raza save(Raza raza) {
		return this.razaRepository.save(raza);
	}

	public boolean delete(int idRaza) {
		boolean result = false;

		if (this.razaRepository.existsById(idRaza)) {
			this.razaRepository.deleteById(idRaza);
			result = true;
		}

		return result;
	}


	public List<Raza> getByNombre(String nombre) {
		return this.razaRepository.findByNombreStartingWithIgnoreCase(nombre);
	}

}

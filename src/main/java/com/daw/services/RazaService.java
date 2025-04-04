package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Raza;
import com.daw.persistence.repositories.RazaRepository;
import com.daw.services.dtos.RazaDTO;
import com.daw.services.mappers.RazaMapper;

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

	public RazaDTO delete(int idRaza) {
        Optional<Raza> razaOptional = razaRepository.findById(idRaza);

        if (razaOptional.isPresent()) {
        	Raza raza = razaOptional.get();
        	razaRepository.delete(raza);
            return RazaMapper.toDTO(raza, false);
        }

        return null;
    }


	public List<Raza> getByNombre(String nombre) {
		return this.razaRepository.findByNombreStartingWithIgnoreCase(nombre);
	}

}

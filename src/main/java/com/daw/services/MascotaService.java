package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.persistence.repositories.MascotaRepository;
import com.daw.services.dtos.MascotaDTO;
import com.daw.services.mappers.MascotaMapper;

import jakarta.transaction.Transactional;

@Service
public class MascotaService {

	@Autowired
	private MascotaRepository mascotaRepository;

	public List<Mascota> findAll() {
		return this.mascotaRepository.findAll();
	}

	public boolean existsMascota(int idMascota) {
		return this.mascotaRepository.existsById(idMascota);
	}

	public Optional<Mascota> findById(int idMascota) {
		return this.mascotaRepository.findById(idMascota);
	}

	public Mascota create(Mascota mascota) {
		return this.mascotaRepository.save(mascota);
	}

	public Mascota save(Mascota mascota) {
		return this.mascotaRepository.save(mascota);
	}

	public MascotaDTO delete(int idMascota) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(idMascota);

        if (mascotaOptional.isPresent()) {
        	Mascota mascota = mascotaOptional.get();
        	mascotaRepository.delete(mascota);
            return MascotaMapper.toDTO(mascota);
        }

        return null;
    }

	public List<Mascota> buscarPorSexo(Sexo sexo) {
		return mascotaRepository.findBySexo(sexo);
	}

	public List<Mascota> buscarPorEspecie(Especie especie) {
		return mascotaRepository.findByEspecie(especie);
	}

	public List<Mascota> buscarPorEsterilizado(Boolean esterilizado) {
		return mascotaRepository.findByEsterilizado(esterilizado);
	}

	public List<Mascota> buscarPorVacunado(Boolean vacunado) {
		return mascotaRepository.findByVacunado(vacunado);
	}

	public List<Mascota> buscarPorDesparasitado(Boolean desparasitado) {
		return mascotaRepository.findByDesparasitado(desparasitado);
	}

	@Transactional
	public Mascota actualizarEsterilizado(Integer id, Boolean esterilizado) {
		Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
		if (mascotaOptional.isPresent()) {
			Mascota mascota = mascotaOptional.get();
			mascota.setEsterilizado(esterilizado);
			return mascotaRepository.save(mascota);
		} else {
			throw new RuntimeException("Mascota no encontrada con ID: " + id);
		}
	}

	@Transactional
	public Mascota actualizarVacunacion(Integer id, Boolean vacunado) {
		Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
		if (mascotaOptional.isPresent()) {
			Mascota mascota = mascotaOptional.get();
			mascota.setVacunado(vacunado);
			return mascotaRepository.save(mascota);
		} else {
			throw new RuntimeException("Mascota no encontrada con ID: " + id);
		}
	}

	@Transactional
	public Mascota actualizarDesparasitado(Integer id, Boolean desparasitado) {
		Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
		if (mascotaOptional.isPresent()) {
			Mascota mascota = mascotaOptional.get();
			mascota.setDesparasitado(desparasitado);
			return mascotaRepository.save(mascota);
		} else {
			throw new RuntimeException("Mascota no encontrada con ID: " + id);
		}
	}

}

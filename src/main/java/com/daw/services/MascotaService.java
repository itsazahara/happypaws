package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.persistence.repositories.MascotaRepository;


@Service
public class MascotaService {
	
	@Autowired
	private MascotaRepository mascotaRepository;
	
	public List<Mascota> findAll(){
		return this.mascotaRepository.findAll();
	}
	
	public boolean existsMascota(int idMascota){
		return this.mascotaRepository.existsById(idMascota);
	}
	
	public Optional<Mascota> findById(int idMascota){
		return this.mascotaRepository.findById(idMascota);
	}
	
	public Mascota create(Mascota mascota) {
		return this.mascotaRepository.save(mascota);
	}
	
	public Mascota save(Mascota mascota) {
		return this.mascotaRepository.save(mascota);
	}
	
	public boolean delete(int idMascota) {
		boolean result = false;
		
		if(this.mascotaRepository.existsById(idMascota)) {
			this.mascotaRepository.deleteById(idMascota);
			result = true;
		}
		
		return result;
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

}

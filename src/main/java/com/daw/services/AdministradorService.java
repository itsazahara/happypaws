package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Administrador;
import com.daw.persistence.repositories.AdministradorRepository;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	public List<Administrador> findAll(){
		return this.administradorRepository.findAll();
	}
	
	public boolean existsAdministrador(int idAdministrador){
		return this.administradorRepository.existsById(idAdministrador);
	}
	
	public Optional<Administrador> findById(int idAdministrador){
		return this.administradorRepository.findById(idAdministrador);
	}
	
	public Administrador create(Administrador administrador) {
		return this.administradorRepository.save(administrador);
	}
	
	public Administrador save(Administrador administrador) {
		return this.administradorRepository.save(administrador);
	}
	
	public boolean delete(int idAdministrador) {
		boolean result = false;
		
		if(this.administradorRepository.existsById(idAdministrador)) {
			this.administradorRepository.deleteById(idAdministrador);
			result = true;
		}
		
		return result;
	}

}

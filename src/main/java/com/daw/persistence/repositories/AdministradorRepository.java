package com.daw.persistence.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Administrador;

public interface AdministradorRepository extends ListCrudRepository<Administrador, Integer>{
	
	Optional<Administrador> findByEmail(String email);
	Optional<Administrador> findByUsuario(String usuario);

}

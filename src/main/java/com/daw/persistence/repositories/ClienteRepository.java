package com.daw.persistence.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Cliente;

public interface ClienteRepository extends ListCrudRepository<Cliente, Integer>{
	
	Optional<Cliente> findByEmail(String email);
	Optional<Cliente> findByUsuario(String usuario);

}

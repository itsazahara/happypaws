package com.daw.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Raza;
import com.daw.persistence.entities.enumerados.Especie;

public interface RazaRepository extends ListCrudRepository<Raza, Integer>{
	
	List<Raza> findByNombreStartingWithIgnoreCase(String nombre);
	List<Raza> findByEspecie(Especie especie);
}

package com.daw.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Sexo;

public interface MascotaRepository extends ListCrudRepository<Mascota, Integer>{
	
	List<Mascota> findBySexo(Sexo sexo);

}

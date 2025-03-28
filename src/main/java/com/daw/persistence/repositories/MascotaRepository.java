package com.daw.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Mascota;

public interface MascotaRepository extends ListCrudRepository<Mascota, Integer>{

}

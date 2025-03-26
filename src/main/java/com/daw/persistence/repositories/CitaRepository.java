package com.daw.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Cita;
import com.daw.persistence.entities.enumerados.Estado;

public interface CitaRepository extends ListCrudRepository<Cita, Integer>{
	
	List<Cita> findByClienteId(int idCliente);

    List<Cita> findByFechaHora(LocalDate fechaHora);

    List<Cita> findByEstado(Estado estado);

}

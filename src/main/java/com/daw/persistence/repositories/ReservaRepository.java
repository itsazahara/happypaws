package com.daw.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Reserva;
import com.daw.persistence.entities.enumerados.Estado;

public interface ReservaRepository extends ListCrudRepository<Reserva, Integer> {

	List<Reserva> findByEstado(Estado estado);

	List<Reserva> findAllByOrderByFechaSolicitudAsc();

	List<Reserva> findAllByOrderByFechaSolicitudDesc();

	List<Reserva> findByClienteId(Integer clienteId);

}

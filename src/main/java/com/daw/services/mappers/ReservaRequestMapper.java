package com.daw.services.mappers;

import com.daw.persistence.entities.Reserva;
import com.daw.services.dtos.ReservaRequestDTO;

public class ReservaRequestMapper {
	
	public static Reserva toEntity(ReservaRequestDTO dto) {
		Reserva reserva = new Reserva();
		
		reserva.setId(dto.getId());
		reserva.setIdAdministrador(dto.getIdAdministrador());
		reserva.setIdCliente(dto.getIdCliente());
		reserva.setIdMascota(dto.getIdMascota());
		reserva.setEstado(dto.getEstado());
		reserva.setObservaciones(dto.getObservaciones());
		
		return reserva;
		
	}

}

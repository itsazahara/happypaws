package com.daw.services.mappers;

import com.daw.persistence.entities.Cita;
import com.daw.services.dtos.CitaDTO;

public class CitaMapper {
	
	public static CitaDTO toDTO(Cita cita) {
		CitaDTO dto = new CitaDTO();

		dto.setId(cita.getId());
		dto.setFechaHora(cita.getFechaHora());
		dto.setNombrePeluquero(cita.getPeluquero().getNombre());
		dto.setEmailPeluquero(cita.getPeluquero().getEmail());
		dto.setNombreMascota(cita.getMascota().getNombre());

		return dto;
	}
}

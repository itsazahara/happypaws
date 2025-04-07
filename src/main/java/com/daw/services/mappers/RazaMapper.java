package com.daw.services.mappers;

import java.util.stream.Collectors;

import com.daw.persistence.entities.Raza;
import com.daw.services.dtos.RazaDTO;

public class RazaMapper {

	public static RazaDTO toDTO(Raza raza, boolean includeMascotas) {
		RazaDTO dto = new RazaDTO();
		dto.setNombre(raza.getNombre());
		dto.setId(raza.getId());
		
		if (includeMascotas && raza.getMascotas() != null) {
			dto.setMascotas(raza.getMascotas().stream().map(MascotaMapper::toDTO).collect(Collectors.toList()));
		}

		return dto;
	}

	public static Raza toEntity(RazaDTO dto) {
		Raza raza = new Raza();
		raza.setNombre(dto.getNombre());
		raza.setId(dto.getId());

		if (dto.getMascotas() != null) {
			raza.setMascotas(dto.getMascotas().stream().map(MascotaMapper::toEntity).collect(Collectors.toList()));
		}

		return raza;
	}
}
